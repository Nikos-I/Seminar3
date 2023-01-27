package gb.org;

public class Main {
    public static void main(String[] args) {
        Staffers st = new Staffers();
        st.pasteBegin(new User("Иван", "Иванов", 32, null));
        st.pasteBegin(new User("Петр", "Петров", 25, null));
        st.pasteEnd(new User("Сидор", "Сидоров", 65, null));
        st.pasteEnd(new User("Анна", "Иванова", 23, null));
        st.pasteBegin(new User("Вита", "Петрова", 25, null));

        st.forEach(o -> System.out.print(o + "\n"));

    }
}
