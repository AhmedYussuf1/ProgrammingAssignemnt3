import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RecordStudioTypesListsDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter path to input file: ");
        String path = in.nextLine().trim();
        System.out.println(path.toString());

        RecordStudioTypesLists lists = new RecordStudioTypesLists();
          try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\t");
                 int type = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int years = Integer.parseInt(parts[2].trim());
                String last = parts[3].trim();

                if (type == 1) {
                     boolean hasLive = Boolean.parseBoolean(last);
                    lists.add(new MusicStudio(name, years, hasLive));
                } else if (type == 2) {

                    int extra = Integer.parseInt(last);
                    lists.add(new SocialMediaContentStudio(name, years, extra));
                } else {

                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

         System.out.println("=== MusicStudio list (type 'a') ===");
        lists.display(lists.getList('a'));
        System.out.println("=== SocialMediaContentStudio list (type 'b') ===");
        lists.display(lists.getList('b'));

         System.out.println("\n-- indexOf tests --");
        RecordStudio lookA1 = new MusicStudio("sample-a1", 10, true);
        RecordStudio lookA2 = new MusicStudio("sample-a2", 5, false);
        // These may or may not exist; indexOf should be -1 if not present.
        System.out.println("indexOf(sample-a1 in 'a'): " + lists.indexOf(lookA1));
        System.out.println("indexOf(sample-a2 in 'a'): " + lists.indexOf(lookA2));

         System.out.println("\n-- get tests --");
        RecordStudioOrderedList aList = lists.getList('a');
        RecordStudioOrderedList bList = lists.getList('b');

         System.out.println("get('a', 1): " + toSafeString(lists.get(aList, 1)));
        System.out.println("get('b', 1): " + toSafeString(lists.get(bList, 1)));
         System.out.println("get('a', 999): " + toSafeString(lists.get(aList, 999)));
        System.out.println("get('b', 0): " + toSafeString(lists.get(bList, 0)));

         System.out.println("\n-- add(index, item) tests --");
        RecordStudio insertA = new MusicStudio("insert-head-a", 1, true);
        boolean addedHeadA = lists.add(1, insertA);       // insert at head of 'a'
        System.out.println("add(1, insert-head-a) => " + addedHeadA);
        lists.display(aList);
    }
    private static String toSafeString(RecordStudio rs) {
        return (rs == null) ? "null" : rs.toString();
    }
}
