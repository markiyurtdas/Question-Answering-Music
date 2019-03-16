package utils;

import model.Album;

public class BinarySearchTree {



    /* Class containing left and right child of current node and key value*/
    class Node {
        Album album;
        Node left, right;

        public Node(Album item) {
            album= item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(Album album) {
        root = insertRec(root, album);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, Album album) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(album);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (album.getAlbumName().compareToIgnoreCase(root.album.getAlbumName()) < 0)
            root.left = insertRec(root.left, album);
        else if (album.getAlbumName().compareToIgnoreCase(root.album.getAlbumName()) > 0)
            root.right = insertRec(root.right, album);

        /* return the (unchanged) node pointer */
        return root;
    }


    //TODO create search method
//   public Album search(Node root, String albumName) {
//
//        /* If the tree is empty, return a null album */
//        if (root.album.getAlbumName().compareToIgnoreCase(albumName) ==0){
//            return root
//        }
//
//        /* Otherwise, recur down the tree */
//        if (album.getAlbumName().compareToIgnoreCase(root.album.getAlbumName()) < 0)
//            root.left = insertRec(root.left, album);
//        else if (album.getAlbumName().compareToIgnoreCase(root.album.getAlbumName()) > 0)
//            root.right = insertRec(root.right, album);
//
//        /* return the (unchanged) node pointer */
//        return album;
//    }

    // This method mainly calls InorderRec()
    public void inorder()  {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
     void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.album.getAlbumName());
            inorderRec(root.right);
        }
    }
}