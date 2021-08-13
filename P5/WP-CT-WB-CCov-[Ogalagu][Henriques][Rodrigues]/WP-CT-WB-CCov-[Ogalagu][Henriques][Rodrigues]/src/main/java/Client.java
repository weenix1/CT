import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;
import com.beust.jcommander.converters.FileConverter;
import com.beust.jcommander.converters.PathConverter;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Client {
    @Parameter(description="input files", required = true, converter = FileConverter.class, validateWith = NoFileValidator.class)
    List<File> inputFiles = new ArrayList<>();

    @Parameter(description = "output dir", names = {"-o", "--output-dir"}, converter = PathConverter.class)
    Path output;

    @Parameter(description="used algorithm", required = true, names = {"-a", "--algorithms"}, validateWith = AlgorithmValidator.class, converter = SupportedAlgorithmConverter.class)
    List<SupportedAlgorithm> algorithms;

    public static void main(String[] argv) {
        Client args = new Client();
        var clientBuilder = JCommander.newBuilder()
                .addObject(args)
                .programName("DecisionCoverageClient")
                .build();
        try {
            clientBuilder.parse(argv);
            args.run();
        } catch (ParameterException e){
            System.out.println(e.getLocalizedMessage());
            clientBuilder.usage();
        }
    }

    public void run() {
        for(var file : inputFiles){
            for(var algorithmEnum : algorithms){
                var table = new TruthTableIO().read(file);

                var algorithm = algorithmEnum.createInstance();

                var newTable = algorithm.create(table);

                var oldFileName = file.getName();
                var removed = oldFileName.substring(0, oldFileName.lastIndexOf('.')); //Get the file type
                var ext = oldFileName.substring(oldFileName.lastIndexOf('.'));
                var newFileName = removed + "_" + algorithmEnum + ext;
                File newFile;

                if(output != null)
                    newFile = new File(output.toFile(), newFileName);
                else
                    newFile = new File(new File(file.getAbsolutePath()).getParent(), newFileName);

                new TruthTableIO().write(newFile, newTable);
            }
        }
}

    public static class NoFileValidator implements IParameterValidator {
        @Override
        public void validate(String name, String value) throws ParameterException {
            if (!new File(value).exists()) {
                throw new ParameterException(value + " does not exist.");
            }
        }
    }

    public static class AlgorithmValidator implements IParameterValidator {
        @Override
        public void validate(String name, String value) throws ParameterException {
            if (!SupportedAlgorithm.isSupported(value)) {
                throw new ParameterException("The Algorithm " + value + " is not supported.");
            }
        }
    }

    public static class SupportedAlgorithmConverter extends BaseConverter<SupportedAlgorithm> {

        public SupportedAlgorithmConverter(String optionName) {
            super(optionName);
        }

        @Override
        public SupportedAlgorithm convert(String value) {
            try {
                return SupportedAlgorithm.valueOf(value.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e) {
                throw new ParameterException(e.getMessage());
            }
        }
    }
}