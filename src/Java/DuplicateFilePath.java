import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class FileData {

    String path;
    String name;
    String content;

    public FileData(String path, String name, String content) {
        this.path = path;
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return path + "/" + name;
    }
}

class FileDataContentComparator implements Comparator<FileData> {

    @Override
    public int compare(FileData o1, FileData o2) {
        if (o1.content.equals(o2.content))
            return 0;
        else
            return 1;
    }
}

// 609. Find Duplicate File in System
public class DuplicateFilePath {

    public List<List<String>> findDuplicate(String[] paths) {

        List<FileData> allFileData = new ArrayList<>();
        List<List<String>> resultData = new ArrayList<>();

        for (String fileData: paths) {
            allFileData.add(getFileData(fileData));
        }

        allFileData.sort(new FileDataContentComparator());

        HashMap<String, List<String>> contentFileDataMap = new HashMap<>();

        for (FileData fd : allFileData) {
            List<String> savedList = new ArrayList<>();

            if (contentFileDataMap.containsKey(fd.content)) {
                savedList = contentFileDataMap.get(fd.content);
            }

            savedList.add(fd.toString());
            contentFileDataMap.put(fd.content, savedList);
        }

        resultData.addAll(contentFileDataMap.values());

        return resultData;
    }

    public FileData getFileData(String path) {

        StringBuilder fileName = new StringBuilder();
        StringBuilder filePath = new StringBuilder();
        StringBuilder fileContent = new StringBuilder();
        int i = 0;

        while (i < path.length()) {

            if (path.charAt(i) == ' ') {
                i++;
                break;
            }

            filePath.append(path.charAt(i));
            i++;
        }

        while (i < path.length()) {

            if (path.charAt(i) == '(') {
                i++;
                break;
            }
            fileName.append(path.charAt(i));
            i++;
        }

        while (i < path.length()) {
            if (path.charAt(i) == ')')
                break;

            fileContent.append(path.charAt(i));
            i++;
        }

        return new FileData(filePath.toString(), fileName.toString(), fileContent.toString());

    }


}
