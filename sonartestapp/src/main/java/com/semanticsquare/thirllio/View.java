package com.semanticsquare.thirllio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;

public class View {
//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println("\n" + user.getEmail() + " is bookmarking");
//		for(int i = 0 ; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//			
//			int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
//			int bookmarkOffset  = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//			
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//			
//			System.out.println(bookmark);
//		}
//	}

    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if (isBookmarked) {
                        bookmarkCount++;

                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);

                        System.out.println("New Item Bookmarked --" + bookmark);

                        if (user.getUserType() == UserType.EDITOR_TYPE
                                || user.getUserType() == (UserType.CHIEF_EDITOR_TYPE)) {

                            // Mark as kid-friendly
                            if (bookmark.isKidFriendlyEligible()
                                    && bookmark.getKidFriendlyStatus() == (KidFriendlyStatus.UNKNOWN)) {
                                String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

                                if (kidFriendlyStatus != (KidFriendlyStatus.UNKNOWN)) {
                                    BookmarkController.getInstance().setKidFriendlyStatus(kidFriendlyStatus, bookmark);
                                }
                            }
                        }

                    }
                }
            }
        }

    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
                : (Math.random() >= .4 && Math.random() < .8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }

}
