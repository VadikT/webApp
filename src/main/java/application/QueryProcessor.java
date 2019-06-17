package application;

public class QueryProcessor {
    public String process(String query) {
        if (query.toLowerCase().contains("gagarin")) {
            return "Yuri Alekseyevich Gagarin  was born (9 March 1934 – 27 March 1968)  " +
                    "was a Soviet Air Forces pilot  " +
                    "and cosmonaut who became the first human to journey into outer space, achieving a major milestone in the Space Rac";
        }
        return "";
    }
}
