import java.util.*;

public class Test2 {
    
    public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
        InvIndexPhotoManager invmanager = new InvIndexPhotoManager();
        PhotoManager manager = new PhotoManager();
        
        Photo photo1 = new Photo("hedgehog.jpg",toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        invmanager.addPhoto(photo1);
        manager.addPhoto(photo1);
        Photo photo2 = new Photo("bear.jpg",toTagsLinkedList("animal, bear, cab, grass, wind"));
        invmanager.addPhoto(photo2);
        manager.addPhoto(photo2);
        Photo photo3 = new Photo("orange-butterfly.jpg",toTagsLinkedList("insect, butterfly, flower, color"));
        invmanager.addPhoto(photo3);
        manager.addPhoto(photo3);
        Photo photo4 = new Photo("panda.jpg", toTagsLinkedList("animal, bear, panda, grass"));
        invmanager.addPhoto(photo4);
        manager.addPhoto(photo4);
        Photo photo5 = new Photo("fox.jpg", toTagsLinkedList("animal, fox, tree, forest, grass"));
        invmanager.addPhoto(photo5);
        manager.addPhoto(photo5);
        
        Album album1 = new Album("Album1", "bear", manager, invmanager);
        Album album2 = new Album("Album2", "animal AND grass", manager, invmanager);
        Album album3 = new Album("Album3", "", manager, invmanager);

      System.out.println("Choose a class:");
        String ch = in.next();

switch(ch){

    case "album" :

        printLLPhoto(album1.getPhotos());


    case "manager":


    case "photo" :



    case "photomanager":


            
    case "invindexphotomanager":

            
}



        
    }

    private static LinkedList<String> toTagsLinkedList(String tags){
        LinkedList<String> result = new LinkedList<String>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (int i = 0; i < tagsArray.length; i++) {
            result.insert(tagsArray[i]);
        }
        return result;
    }
    
    private static void printLLPhoto(LinkedList<Photo> list) {
        if (list.empty()) return;

        list.findFirst();
        while (!list.last()) {
            System.out.println(list.retrieve().getPath());
            list.findNext();
        }
    System.out.println(list.retrieve().getPath());
    }
    
    }
