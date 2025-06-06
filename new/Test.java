package csc212;
public class Test {
    public static void main(String[] args) {
    
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
        
        
        System.out.println("Get photo1 path and tags:");
        System.out.println("photo1 path: " + photo1.getPath());
        
        //You can get the list of tags of photo1 by calling photo1.getTags().
        LinkedList<String> tags = photo1.getTags();
        
        //You can write a method that prints the list of tags of photo1.
        System.out.println(photo1.getPath());
        printLL(tags);
        
        System.out.println("\n\nGet album1 name, condition, and photos:");
        System.out.println("album1 name: " + album1.getName());
        System.out.println("album1 condition: " + album1.getCondition());
         //You can get the list of photos in album1 by calling album1.getPhotos().
        LinkedList<Photo> photos = album1.getPhotos();
        //You can write a method that prints the list of photos in album1.
        System.out.println(album1.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", album1.getCondition(), album1.getNbComps());
     
        System.out.println("\n\nGet album2 name, condition, and photos:");
        System.out.println("album2 name: " + album2.getName());
        System.out.println("album2 condition: " + album2.getCondition());
  //You can get the list of photos in album2 by calling album2.getPhotos().
        photos = album2.getPhotos();
        //You can write a method that prints the list of photos in album2.
        System.out.println(album2.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", album2.getCondition(), album2.getNbComps());
      
        System.out.println("\n\nGet album3 name, condition, and photos:");
        System.out.println("album3 name: " + album3.getName());
        System.out.println("album3 condition: " + album3.getCondition());
  //You can get the list of photos in album3 by calling album2.getPhotos().
        photos = album3.getPhotos();
        //You can write a method that prints the list of photos in album3.
        System.out.println(album3.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", album3.getCondition(), album3.getNbComps());

        
        System.out.println("\n\nDelete the photo ’bear.jpg’:");
        manager.deletePhoto("bear.jpg");
        invmanager.deletePhoto("bear.jpg"); 
        
        System.out.println("\n\nGet album3 name, condition, and photos:");
        System.out.println("album3 name: " + album3.getName());
        System.out.println("album3 condition: " + album3.getCondition());
        //You can get the list of photos in album2 by calling album3.getPhotos().
        photos = album3.getPhotos();
        //You can write a method that prints the list of photos in album3.
        System.out.println(album3.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", album3.getCondition(), album3.getNbComps());

    }
    
    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<String>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (int i = 0; i < tagsArray.length; i++) {
            result.insert(tagsArray[i]);
        }
        return result;
    }
    
     
    private static void printLL(LinkedList<String> list) {
        if (list.empty()) return;

        list.findFirst();
        while (!list.last()) {
            System.out.print(list.retrieve() + " ");
            list.findNext();
        }

        // Print the last item after the loop
        System.out.print(list.retrieve() + " ");
    }

    private static void printLLPhoto(LinkedList<Photo> list) {
        if (list.empty()) return;

        list.findFirst();
        while (!list.last()) {
            System.out.println(list.retrieve().getPath());
            list.findNext();
        }

        // Print the last photo after the loop
        System.out.println(list.retrieve().getPath());
    }

       
    
}
