import io.bio.Virus;

public class Virus_test {
    public static void main(String[] args) {
        String path= Virus.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        System.out.println(path);
        String[] split=path.split("/");
        String oldPath=split[split.length-1].replaceAll("\\d+","");
        System.out.println(oldPath);
    }
}
