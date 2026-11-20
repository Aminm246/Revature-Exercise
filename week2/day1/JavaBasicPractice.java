package com.day1;

public class JavaBasicPractice {

    // ---------- Q1: Reverse a number without using String ----------
    static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    static void q1() {
        System.out.println(reverse(12345));
        System.out.println(reverse(908));
        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
    }

    // ---------- Q2: Type casting challenge ----------
    static void q2() {
        int a = 10;
        double b = 3.5;
        int result = (int) (a + b);
        System.out.println(result);
        char ch = 'A';
        int value = ch + 5;
        System.out.println(value);
        System.out.println((char) value);

        // implicit (widening) and explicit (narrowing) casting
        int i = 100;
        double d = i;
        long l = i;
        System.out.println(d + " " + l);
        double pi = 3.99;
        int n = (int) pi;
        byte by = (byte) 130;
        System.out.println(n + " " + by);
    }

    // ---------- Q3: Count vowels and consonants ----------
    static void q3() {
        String s = "Programming";
        int vowels = 0, consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // ---------- Q4: String to wrapper classes ----------
    static void q4() {
        String age = "25";
        String salary = "45000.75";
        String active = "true";
        try {
            Integer ageValue = Integer.valueOf(age);
            Double salaryValue = Double.valueOf(salary);
            Boolean activeValue = Boolean.valueOf(active);
            double newSalary = salaryValue + (salaryValue * 10 / 100);
            System.out.println("Age: " + ageValue + " (" + ageValue.getClass().getSimpleName() + ")");
            System.out.println("Salary: " + salaryValue + " (" + salaryValue.getClass().getSimpleName() + ")");
            System.out.println("Active: " + activeValue + " (" + activeValue.getClass().getSimpleName() + ")");
            System.out.println("Salary after 10% increment: " + newSalary);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input: " + e.getMessage());
        }
    }

    // ---------- Q5: Anagrams ----------
    static boolean isAnagram(String a, String b) {
        a = a.replace(" ", "").toLowerCase();
        b = b.replace(" ", "").toLowerCase();
        if (a.length() != b.length()) return false;
        int[] count = new int[65536];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }

    static void q5() {
        System.out.println(isAnagram("listen", "silent") ? "Anagram" : "Not Anagram");
        System.out.println(isAnagram("hello", "world") ? "Anagram" : "Not Anagram");
    }

    // ---------- Q6: Swap without a third variable ----------
    static void q6() {
        int a = 10, b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int x = 10, y = 20;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int p = Integer.MAX_VALUE, q = 5;
        p = p + q;
        q = p - q;
        p = p - q;
        System.out.println("p = " + p + ", q = " + q);
    }

    // ---------- Q7: Pass by value ----------
    static void modify(int x) { x = 100; }
    static void modifyArray(int[] arr) { arr[0] = 100; }
    static void reassignArray(int[] arr) { arr = new int[]{999, 888, 777}; }

    static void q7() {
        int a = 10;
        int[] numbers = {10, 20, 30};
        modify(a);
        modifyArray(numbers);
        System.out.println(a);
        System.out.println(numbers[0]);

        int[] other = {10, 20, 30};
        reassignArray(other);
        System.out.println(other[0]);
    }

    // ---------- Q8: Remove duplicate characters ----------
    static void q8() {
        String s = "programming";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) == -1) sb.append(c);
        }
        System.out.println(sb);
    }

    // ---------- Q9: First non-repeated character ----------
    static String firstNonRepeated(String s) {
        int[] count = new int[65536];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i)] == 1) return String.valueOf(s.charAt(i));
        return "No non-repeated character";
    }

    static void q9() {
        System.out.println(firstNonRepeated("swiss"));
        System.out.println(firstNonRepeated("aabbcc"));
    }

    // ---------- Q10: Predict the String output ----------
    static void q10() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println(sb);
        System.out.println(s1);
    }

    // ---------- Q11: Longest substring without repeating characters ----------
    static int lengthOfLongestSubstring(String s) {
        int[] last = new int[65536];
        java.util.Arrays.fill(last, -1);
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last[c] >= start) start = last[c] + 1;
            last[c] = i;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    static void q11() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    // ---------- Q12: String compression ----------
    static String compress(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    static void q12() {
        System.out.println(compress("aaabbccccd"));
        System.out.println(compress("abc"));
        System.out.println(compress("a"));
    }

    // ---------- Q13: Reverse words without split ----------
    static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            if (result.length() > 0) result.append(' ');
            result.append(s, i + 1, end + 1);
        }
        return result.toString();
    }

    static void q13() {
        System.out.println(reverseWords("Java is easy to learn"));
        System.out.println("[" + reverseWords("   Java   is  easy   ") + "]");
    }

    // ---------- Q14: StringBuilder vs StringBuffer ----------
    static void q14() throws Exception {
        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append("x");
            sf.append("x");
        }
        System.out.println("Single thread -> StringBuilder length: " + sb.length());
        System.out.println("Single thread -> StringBuffer length: " + sf.length());
        System.out.println("Outputs equal: " + sb.toString().equals(sf.toString()));

        final StringBuilder sharedBuilder = new StringBuilder();
        Runnable r1 = () -> { for (int i = 0; i < 100000; i++) sharedBuilder.append("a"); };
        Thread t1 = new Thread(r1), t2 = new Thread(r1);
        try {
            t1.start(); t2.start(); t1.join(); t2.join();
            System.out.println("StringBuilder length (expected 200000): " + sharedBuilder.length());
        } catch (Exception e) {
            System.out.println("StringBuilder failed: " + e);
        }

        final StringBuffer sharedBuffer = new StringBuffer();
        Runnable r2 = () -> { for (int i = 0; i < 100000; i++) sharedBuffer.append("a"); };
        Thread t3 = new Thread(r2), t4 = new Thread(r2);
        t3.start(); t4.start(); t3.join(); t4.join();
        System.out.println("StringBuffer length (expected 200000): " + sharedBuffer.length());
    }

    // ---------- Q15: Employee salary processing ----------
    static class Employee {
        int id;
        String name;
        double basicSalary;
        double bonusPercentage;
        Boolean active;

        Employee(int id, String name, double basicSalary, double bonusPercentage, Boolean active) {
            this.id = id;
            this.name = name;
            this.basicSalary = basicSalary;
            this.bonusPercentage = bonusPercentage;
            this.active = active;
        }

        double bonus() { return basicSalary * bonusPercentage / 100; }
        double finalSalary() { return basicSalary + bonus(); }
    }

    static Employee create(String id, String name, String salary, String bonusPct, String active) {
        try {
            return new Employee(Integer.parseInt(id), name, Double.parseDouble(salary),
                    Double.parseDouble(bonusPct), Boolean.valueOf(active));
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary input: " + e.getMessage());
            return null;
        }
    }

    static void q15() {
        Employee e = create("101", "Rahul", "60000", "20", "true");
        if (e != null) {
            String upper = e.name.toUpperCase();
            String reversed = new StringBuilder(e.name).reverse().toString();
            System.out.println("Employee ID: " + e.id);
            System.out.println("Employee Name: " + upper);
            System.out.println("Basic Salary: " + e.basicSalary);
            System.out.println("Bonus: " + e.bonus());
            System.out.println("Final Salary: " + e.finalSalary());
            System.out.println("Active: " + e.active);
            System.out.println("Reversed Name: " + reversed);
            System.out.println("Salary above 75000: " + (e.finalSalary() > 75000 ? "Yes" : "No"));

            System.out.println();
            Employee ref = e;
            Employee copy = new Employee(e.id, e.name, e.basicSalary, e.bonusPercentage, e.active);
            ref.name = "Changed";
            System.out.println("Original name after changing via reference: " + e.name);
            System.out.println("Copy name (separate object): " + copy.name);
            System.out.println("e == ref: " + (e == ref) + ", e == copy: " + (e == copy));
        }
        System.out.println();
        create("102", "Asha", "abc", "10", "true");
    }

    // ---------- Bonus: Longest palindromic substring ----------
    static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < 2; k++) {
                int l = i, r = i + k;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
                int len = r - l - 1;
                if (len > maxLen) { maxLen = len; start = l + 1; }
            }
        }
        return s.substring(start, start + maxLen);
    }

    static void bonus() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    // ---------- Main: runs every question ----------
    static void header(String title) {
        System.out.println();
        System.out.println("===== " + title + " =====");
    }

    public static void main(String[] args) throws Exception {
        header("Q1"); q1();
        header("Q2"); q2();
        header("Q3"); q3();
        header("Q4"); q4();
        header("Q5"); q5();
        header("Q6"); q6();
        header("Q7"); q7();
        header("Q8"); q8();
        header("Q9"); q9();
        header("Q10"); q10();
        header("Q11"); q11();
        header("Q12"); q12();
        header("Q13"); q13();
        header("Q14"); q14();
        header("Q15"); q15();
        header("Bonus"); bonus();
    }
}