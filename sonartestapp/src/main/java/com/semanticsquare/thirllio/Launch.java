package com.semanticsquare.thirllio;

import com.semanticsquare.thirllio.managers.BookmarkManager;
import com.semanticsquare.thirllio.managers.UserManager;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;

public class Launch {

    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading Data ... ");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

//		System.out.println("Printing data ...");
//		printUserData();
//		
//		System.out.println("Printing Bookmark ...");
//		printBookmarkData();
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarklist : bookmarks) {
            for (Bookmark bookmark : bookmarklist) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        loadData();
        start();
    }

    private static void start() {
//		System.out.println("\n2. Bookmarking ... ");
        for (User user : users) {
//			View.bookmark(user, bookmarks);
            View.browse(user, bookmarks);
        }
    }
}
