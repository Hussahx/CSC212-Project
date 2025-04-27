package csc212;
public class Test3 {
    public static void main(String[] args) {
    
        InvIndexPhotoManager invmanager = new InvIndexPhotoManager();
        PhotoManager manager = new PhotoManager();
        
        Photo p1 = new Photo("hedgehog.jpg",toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        invmanager.addPhoto(p1);
        manager.addPhoto(p1);
        Photo p2 = new Photo("bear.jpg",toTagsLinkedList("animal, bear, cab, grass, wind"));
        invmanager.addPhoto(p2);
        manager.addPhoto(p2);
        Photo p3 = new Photo("orange-butterfly.jpg",toTagsLinkedList("insect, butterfly, flower, color"));
        invmanager.addPhoto(p3);
        manager.addPhoto(p3);
        Photo p4 = new Photo("panda.jpg", toTagsLinkedList("animal, bear, panda, grass"));
        invmanager.addPhoto(p4);
        manager.addPhoto(p4);
        Photo p5 = new Photo("fox.jpg", toTagsLinkedList("animal, fox, tree, forest, grass"));
        invmanager.addPhoto(p5);
        manager.addPhoto(p5);

        Album firstAlbum = new Album("Album One", "bear", manager, invmanager);
        Album secondAlbum = new Album("Album Two", "animal AND grass", manager, invmanager);
        Album thirdAlbum = new Album("Album Three", "", manager, invmanager);
        
        
        System.out.println("show p1 path and tags:");
        System.out.println("p1 path: " + p1.getPath());
        
        LinkedList<String> tags = p1.getTags();
        printLL(tags);
        System.out.println("\n");
        System.out.println("show album number 1 name and condition and photos:");
        System.out.println("album one name: " + firstAlbum.getName());
        System.out.println("album one condition: " + firstAlbum.getCondition());
        LinkedList<Photo> photos = firstAlbum.getPhotos();// list the photos in an album
        System.out.println(firstAlbum.getCondition());
        printLLPhoto(photos);
        System.out.printf("the number of comparisons of condition \"%s\" is %d", firstAlbum.getCondition(), firstAlbum.getNbComps());
        
        System.out.println("\n");
        System.out.println("show album two name and condition and photos:");
        System.out.println("album two name: " + secondAlbum.getName());
        System.out.println("album two condition: " + secondAlbum.getCondition());
        photos = secondAlbum.getPhotos();
        System.out.println(secondAlbum.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", secondAlbum.getCondition(), secondAlbum.getNbComps());
        System.out.println("\n");
        System.out.println("show album three name, condition, and photos:");
        System.out.println("album3 name: " + thirdAlbum.getName());
        System.out.println("album3 condition: " + thirdAlbum.getCondition());
        photos = thirdAlbum.getPhotos();
        System.out.println(thirdAlbum.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", thirdAlbum.getCondition(), thirdAlbum.getNbComps());

        System.out.println("");
        System.out.println("Delete the photo ’bear.jpg’:");
        manager.deletePhoto("bear.jpg");
        invmanager.deletePhoto("bear.jpg"); 
        
        System.out.println("");
        System.out.println("now show album three name, condition, and photos again:");
        System.out.println("album three name: " + thirdAlbum.getName());
        System.out.println("album three condition: " + thirdAlbum.getCondition());
        photos = thirdAlbum.getPhotos();
        System.out.println(thirdAlbum.getCondition());
        printLLPhoto(photos);
        System.out.printf("Number of comparisons of condition \"%s\" is %d", thirdAlbum.getCondition(), thirdAlbum.getNbComps());

    }
    
    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> seperatedTags = new LinkedList<String>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (int i = 0; i < tagsArray.length; i++) {
        	seperatedTags.insert(tagsArray[i]);
        }
        return seperatedTags;
    }
  
    private static void printLL(LinkedList<String> list) {
        if (list.empty()) return;

        list.findFirst();
        while (!list.last()) {
            System.out.print(list.retrieve() + " ");
            list.findNext();
        }

        System.out.print(list.retrieve() + " ");//last item
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
