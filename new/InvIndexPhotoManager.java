package csc212;

public class InvIndexPhotoManager {
        BST<LinkedList<Photo>> Inverted_Index;
        
        // Constructor
        public InvIndexPhotoManager()
        {
            Inverted_Index = new BST<LinkedList<Photo>>();
        }
        
        // Add a photo
        public void addPhoto(Photo p) {
            LinkedList<String> tags = p.getTags();
            
          /*  if (!tags.empty()) {
                tags.findFirst();
                while (!tags.last()) {
                    String tag = tags.retrieve();
                    if (Inverted_Index.findkey(tag)) {
                        LinkedList<Photo> photoList = Inverted_Index.retrieve();
                        photoList.insert(p);
                        Inverted_Index.update(tag, photoList);
                    } else {
                        LinkedList<Photo> photoList = new LinkedList<Photo>();
                        photoList.insert(p);
                        Inverted_Index.insert(tag, photoList);
                    }
                    tags.findNext();
                }*/
            if (!tags.empty()) {
                tags.findFirst();
                do {
                    String tag = tags.retrieve();
                    if (Inverted_Index.findkey(tag)) {
                        LinkedList<Photo> photoList = Inverted_Index.retrieve();
                        photoList.insert(p);
                        Inverted_Index.update(tag, photoList);
                    } else {
                        LinkedList<Photo> photoList = new LinkedList<Photo>();
                        photoList.insert(p);
                        Inverted_Index.insert(tag, photoList);
                    }
                    if (!tags.last()) {
                        tags.findNext();
                    }
                } while (!tags.last());
            


                // Handle the last tag after loop
                String tag = tags.retrieve();
                if (Inverted_Index.findkey(tag)) {
                    LinkedList<Photo> photoList = Inverted_Index.retrieve();
                    photoList.insert(p);
                    Inverted_Index.update(tag, photoList);
                } else {
                    LinkedList<Photo> photoList = new LinkedList<Photo>();
                    photoList.insert(p);
                    Inverted_Index.insert(tag, photoList);
                }
            }
        }

        
        // Delete a photo
        public void deletePhoto(String path) {
            String allTagsString = Inverted_Index.inOrder(); // get all tags as one string
            if (allTagsString.isEmpty()) {
                return;
            }

            // Split the tags
            String[] tags = allTagsString.split(" AND ");

            for (String tag : tags) {
                if (Inverted_Index.findkey(tag)) {
                    LinkedList<Photo> photoList = Inverted_Index.retrieve();

                    if (!photoList.empty()) {
                        photoList.findFirst();
                        while (!photoList.last()) {
                            if (photoList.retrieve().getPath().equalsIgnoreCase(path)) {
                                photoList.remove();
                                break;
                            }
                            photoList.findNext();
                        }
                        // Check the last photo
                        if (!photoList.empty() && photoList.retrieve().getPath().equalsIgnoreCase(path)) {
                            photoList.remove();
                        }

                        if (photoList.empty()) {
                            Inverted_Index.removeKey(tag);
                        } else {
                            Inverted_Index.update(tag, photoList);
                        }
                    }
                }
            }
        }
        public BST<LinkedList<Photo>> getPhotos()
        {
            return Inverted_Index;
        }
}
        

