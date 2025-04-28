import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        InvIndexPhotoManager invmanager = new InvIndexPhotoManager();
        PhotoManager manager = new PhotoManager();

        
        Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        manager.addPhoto(photo1);
        invmanager.addPhoto(photo1);

        
        Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass, wind"));
        invmanager.addPhoto(photo2);

        Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect, butterfly, flower, color"));
        invmanager.addPhoto(photo3);

        Album album1 = new Album("Album1", "bear", manager, invmanager);
        Album album2 = new Album("Album2", "animal AND grass", manager, invmanager);
        Album album3 = new Album("Album3", "", manager, invmanager);

        
        System.out.println("\nChoose a class to test:");
        System.out.println("1- Photo");
        System.out.println("2- Photo Manager");
        System.out.println("3- Inv Index Photo Manager");
        System.out.println("4- Album");
        System.out.println("5- Print All Content");

        int ch = in.nextInt();

        switch (ch) {

            case 1:
                System.out.println("\n--- Testing Photo class ---");
                System.out.println(photo1.toString());
                System.out.println(photo2.toString());
                System.out.println(photo3.toString());
                break;

            case 2:
                System.out.println("\n--- Testing PhotoManager ---");
                System.out.println("Photos managed by PhotoManager:");
                printLLPhoto(manager.getPhotos());

                System.out.println("\nDeleting 'bear.jpg'...");
                manager.deletePhoto("bear.jpg");

                System.out.println("Photos after deletion:");
                printLLPhoto(manager.getPhotos());
                break;

            case 3:
                System.out.println("\n--- Testing InvIndexPhotoManager (Inverted Index) ---");
                System.out.println("Tags in the inverted index:");
                System.out.println(invmanager.getPhotos().inOrder());

                System.out.println("\nDeleting 'fox.jpg' from InvIndexPhotoManager...");
                invmanager.deletePhoto("fox.jpg"); // safe, even if fox.jpg doesn't exist

                System.out.println("Tags after deletion:");
                System.out.println(invmanager.getPhotos().inOrder());
                break;

            case 4:
                System.out.println("\n--- Testing Album class ---");

                System.out.println("\nPhotos matching condition '" + album1.getCondition() + "' in Album1:");
                printLLPhoto(album1.getPhotos());
                System.out.printf("Number of comparisons: %d\n", album1.getNbComps());

                System.out.println("\nPhotos matching condition '" + album2.getCondition() + "' in Album2:");
                printLLPhoto(album2.getPhotos());
                System.out.printf("Number of comparisons: %d\n", album2.getNbComps());

                System.out.println("\nAll Photos in Album3 (no condition):");
                printLLPhoto(album3.getPhotos());
                System.out.printf("Number of comparisons: %d\n", album3.getNbComps());
                break;

            case 5:
                System.out.println("\n--- Printing everything ---");

                System.out.println("\nPhotos:");
                System.out.println(photo1);
                System.out.println(photo2);
                System.out.println(photo3);

                System.out.println("\nPhotos in PhotoManager:");
                printLLPhoto(manager.getPhotos());

                System.out.println("\nTags in InvIndexPhotoManager:");
                System.out.println(invmanager.getPhotos().inOrder());

                System.out.println("\nPhotos in Album1:");
                printLLPhoto(album1.getPhotos());

                System.out.println("\nPhotos in Album2:");
                printLLPhoto(album2.getPhotos());

                System.out.println("\nPhotos in Album3:");
                printLLPhoto(album3.getPhotos());
                break;

            default:
                System.out.println("Invalid choice!");
        }

        System.out.println("\nProgram finished.");
    }

    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (String tag : tagsArray) {
            result.insert(tag);
        }
        return result;
    }

    private static void printLLPhoto(LinkedList<Photo> list) {
        if (list.empty()) {
            System.out.println("(Empty List)");
            return;
        }
        list.findFirst();
        do {
            System.out.println(list.retrieve().getPath());
            if (list.last()) break;
            list.findNext();
        } while (true);
    }
}
