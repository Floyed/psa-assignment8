package edu.neu.psa;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {

        String[] wordArray = {"hot","dot","dog","lot","log","cog"};

        System.out.println(ladderLength("hit","cog",Arrays.asList(wordArray)));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        int numChanges = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            numChanges++;

            while (size > 0) {

                size--;

                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) return numChanges;

                for (int i = 0; i < currentWord.length(); i++) {

                    char[] charArray = currentWord.toCharArray();

                    for (int j = 0 ; j <= 26 ; j ++) {

                        char currentChar = (char) ('a' + j);

                        charArray[i] = currentChar;

                        String newWord = new String(charArray);

                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

}
