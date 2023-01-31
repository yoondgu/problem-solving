import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] member = bufferedReader.readLine().split(" ");
            members.add(new Member(i, Integer.parseInt(member[0]), member[1]));
        }

        Collections.sort(members);

        StringBuilder output = new StringBuilder();
        members.forEach(member -> output.append(String.join(" ", String.valueOf(member.age), member.name))
                .append("\n"));
        System.out.println(output);
    }

    static class Member implements Comparable<Member> {
        int index;
        int age;
        String name;

        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (age == o.age) {
                return index - o.index;
            }
            return age - o.age;
        }
    }
}