package datastructur;
import java.util.Scanner;

public class Album {
        private String n;
        private String cond;
        private PhotoManager man;
        private InvIndexPhotoManager invman;
        private int NbComps;

      
        public Album(String name, String condition, PhotoManager manager, InvIndexPhotoManager invmanager )
        {
            this.n = name;
            this.cond = condition;
            this.man = manager;
            this.invman= invmanager;
            NbComps =0;
        }
        
        
        public LinkedList<Photo> getPhotos()
        {
            int choice = menu();
            
            LinkedList<Photo> result = new LinkedList<Photo>();
            switch (choice )
            {
                case 1:
                    result = getPhotosLL();
                    break;
                default:
                    result = getPhotosBST();
        }
        return result;
        }
            
      
       private LinkedList<Photo> getPhotosLL()
       {
                LinkedList<Photo> Rphotos = new LinkedList<Photo>();
                {
                    LinkedList<Photo> photos1 = man.getPhotos();
                    if (! photos1.empty())
                    {
                        photos1.findFirst();
                        while (! photos1.last())
                        {
                            Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                            photos1.findNext();
                        }
                        Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                    }
                }
                NbComps =0 ;
                
                if (this.cond.compareTo("") != 0)
                {
                    String [] Array = cond.split(" AND ");
                    
                    Rphotos.findFirst();
                    while ( ! Rphotos.last())
                    {
                        Photo photo = Rphotos.retrieve();
                       
                        if ( ! allAvilable (photo.allTags , Array ))
                            Rphotos.remove();
                        else
                            Rphotos.findNext();
                    }
                    Photo photo11 = Rphotos.retrieve();
                    
                    if ( ! allAvilable (photo11.allTags , Array ))
                        Rphotos.remove();
                    else
                        Rphotos.findNext();
                }
                return Rphotos;
        }
       

        private boolean allAvilable ( LinkedList<String> AllTags , String [] Array )
        {
            boolean cont1 = true;
            if (AllTags.empty())
                cont1 = false;
            else
            {
                for ( int i = 0 ; i < Array.length && cont1 ; i++)
                {
                    boolean found_in_tags = false;

                    AllTags.findFirst();

                    while (!AllTags.last())
                    {
                        this.NbComps ++ ;  
                        if (AllTags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                        {
                            found_in_tags = true;
                            break;
                        }
                        AllTags.findNext();
                    }
                    if (! found_in_tags )
                    {
                        this.NbComps ++ ;
                        if (AllTags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                            found_in_tags = true;
                    }
                    if ( ! found_in_tags )
                        cont1 = false;
                }
            }
            return cont1;
        }

        
        private LinkedList<Photo> getPhotosBST()
        {
            BST<LinkedList<Photo>> photosBST = invman.getPhotos();
            LinkedList<Photo> Rphotos = new LinkedList<Photo>();
            NbComps =0 ;
            String [] tags;
            

            if (this.cond.compareTo("") == 0)
            {
                if ( photosBST.findkey(" ") == true)
                    Rphotos = photosBST.retrieve();
            }
            else
            {
                tags = cond.split(" AND ");
                for ( int i = 0 ; i < tags.length ; i++)
                {
                    if ( photosBST.findkey(tags[i]) == true)
                    {
                        if (i == 0)
                        {
                            LinkedList<Photo > miniTag = photosBST.retrieve();
                            miniTag.findFirst();
                            while ( ! miniTag.last())
                            {
                                Rphotos.insert(miniTag.retrieve());
                                miniTag.findNext();
                            }
                            Rphotos.insert(miniTag.retrieve());
                        }
                        else
                            Rphotos  = intersect ( Rphotos , photosBST.retrieve());
                    }
                    else
                    {
                        Rphotos = new LinkedList<Photo>();
                        break;
                    }
                }
            }
            return Rphotos;
        }

        
        
        private LinkedList<Photo> intersect(LinkedList<Photo> list1, LinkedList<Photo> list2) 
        {
            LinkedList<Photo> result = new LinkedList<Photo>();
            if (list1.empty()) {
                return result;
            }

            if (list2.empty()) {
                return list1;
            }
            list2.findFirst();
            while (true) {
                Photo currentPhoto = list2.retrieve();
                if (inList(currentPhoto, list1)) {
                    result.insert(currentPhoto);
                }

                if (list2.last()) {
                    break;
                }
                list2.findNext();
            }

            return result;
        }

        
        private boolean inList(Photo target, LinkedList<Photo> list) 
        {
        list.findFirst();
        while (true) {
            NbComps++;
            if (target.getPath().compareToIgnoreCase(list.retrieve().getPath()) == 0) {
                return true;
            }

            if (list.last()) {
                break;
            }
            list.findNext();
        }
        return false;
        }

        
        //Menu
        private int menu()
        {
            Scanner input = new Scanner ( System.in);
        
             System.out.println("\nChoose search method");
            System.out.println("1. Linked List");
            System.out.println("2. BST");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            
            return choice;
            
        }
        
        
        public String getName()
        {
            return n;
        }
        
        
        public String getCondition()
        {
            return cond;
        }

        
        public PhotoManager getManager()
        {
            return man;
        }

        
        public InvIndexPhotoManager getInvManager()
        {
            return invman;
        }
        
        
        public int getNbComps()
        {
            return NbComps;
        }
}

