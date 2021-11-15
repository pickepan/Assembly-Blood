package Pipeline;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Pipeline {
    private static boolean isEqual(Path firstFile, Path secondFile)
    {
        try {
            if (Files.size(firstFile) != Files.size(secondFile)) {
                return false;
            }

            byte[] first = Files.readAllBytes(firstFile);
            byte[] second = Files.readAllBytes(secondFile);
            return Arrays.equals(first, second);
        } catch (IOException e) {
        }
        return false;
    }

    public boolean compare(String fp1, String fp2)
    {
        File firstFile = new File(fp1);
        File secondFile = new File(fp2);

        return isEqual(firstFile.toPath(), secondFile.toPath());
    }
}
