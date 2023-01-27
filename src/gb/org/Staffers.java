package gb.org;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Staffers implements Iterable<User> {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

//    public void addUser(User user){
//        users.add(user);
//    }

    private int findUser(User u) {
        int indUser;
        indUser = users.indexOf(u);
        return indUser;
    }

    private User findFirst() {
        User fUser;
        for (User u : users) {
            if (u.predUser == null) {
                return u;
            }
        }
        //        Stream<User> user = users.stream().filter(s->s.predUser==null);
        return null;
    }

    private User findLast() {
        User lUser;
        for (User u : users) {
            if (u.nextUser == null) {
                return u;
            }
        }
        //        Stream<User> user = users.stream().filter(s->s.predUser==null);
        return null;
    }

    public void pasteBegin(User u) {
        if (users.size() == 0) {
            users.add(0, u);
            return;
        }
        User fUser = findFirst();
        u.nextUser = fUser;
        fUser.predUser = u;
        users.add(users.size(), u);
    }

    public void pasteEnd(User u) {
        if (users.size() == 0) {
            users.add(0, u);
            return;
        }
        User lUser = findLast();
        u.predUser = lUser;
        lUser.nextUser = u;
        users.add(users.size(), u);
    }

    public void pasteAfter(User u, User au) {
        if (users.size()==0){
            users.add(0,u);
            return;
        }
        int indAfter = findUser(au);
        User tu = users.get(indAfter).nextUser;
        users.get(indAfter).nextUser = u;
        u.predUser = users.get(indAfter);
        users.get(indAfter).nextUser.predUser = u;
        u.nextUser= users.get(indAfter).nextUser;

        users.add(users.size(), u);
    }

    @Override
    public Iterator<User> iterator() {

        return new UserIterator();
    }

    private class UserIterator implements Iterator<User> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return users.get(currentIndex).nextUser != null;
        }

        @Override
        public User next() {
            return users.get(currentIndex++).nextUser;
        }
    }


}
