package console.common;

import console.exception.ConsoleMessageException;
import java.io.File;

public class PathUtils {
    /** the solidity file default directory */
    public static final String SOL_DIRECTORY = "contracts/solidity";
    /** solidity file ext name */
    public static final String SOL_POSTFIX = ".sol";

    /**
     * Remove the suffix of the name
     *
     * @param name
     * @param postfix
     * @return
     */
    public static String removePostfix(String name, String postfix) {
        if (name.endsWith(postfix)) {
            return name.substring(0, name.length() - postfix.length());
        }

        return name;
    }

    /**
     * @param filePathOrName
     * @return
     */
    public static File getSolFile(String filePathOrName) throws ConsoleMessageException {

        String filePath = filePathOrName;
        filePath = removePostfix(filePath, SOL_POSTFIX);
        filePath += SOL_POSTFIX;
        /** Check that the file exists in the default directory first */
        File solFile = new File(SOL_DIRECTORY + File.separator + filePath);
        if (!solFile.exists()) {
            /** Check if the file exists */
            solFile = new File(filePath);
        }

        /** file not exist */
        if (!solFile.exists()) {
            throw new ConsoleMessageException(filePathOrName + " does not exist ");
        }

        return solFile;
    }
}
