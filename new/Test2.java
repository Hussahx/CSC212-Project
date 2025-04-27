public class Test {
    public static void main(String[] args) {

      Scanner in = new Scanner(system.in);
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

      System.out.println("Chhose a class:")
        string ch = in.nextInt();

switch(ch)

    case album :



    case manager:


    case photo :



    case photomanager:


            
    case invindexphotomanager:

            




        
    }
}

