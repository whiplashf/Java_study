package generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GenericHomework01 {
    public static void main(String[] args) {
        User user1 = new User("jack",2013,18);
        User user2 = new User("rosi",2014,19);
        User user3 = new User("moit",2015,20);

        Dao<User> userDao = new Dao<>();
        userDao.save("001",user1);
        userDao.save("002",user2);
        userDao.save("003",user3);
        System.out.println(userDao.map);

        System.out.println(userDao.get("003"));
        userDao.delete("001");
        System.out.println(userDao.list());



    }
}

class Dao<T> {
    public Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    @Test
    public List<T> list() {
        Set<String> keys = map.keySet();
        List<T> ts = new ArrayList<>();
        for (String o : keys) {
            ts.add(get(o));
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                "}\n";
    }
}
