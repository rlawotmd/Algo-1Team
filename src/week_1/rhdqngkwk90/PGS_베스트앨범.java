package week_1.rhdqngkwk90;

import java.util.*;

public class PGS_베스트앨범 {
    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 600, 150, 800, 2500};

    public static void main(String[] args) {

        // 정답을 저장할 ArrayList
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<>(); //장르, 재생수
        Map<Integer, String> map2 = new HashMap<>(); //index, 장르

        for(int i = 0; i < genres.length; i++){
            if (map1.containsKey(genres[i])) {
                // 해당 key를 가진 value가 존재하는 경우, 기존 value에 현재 값을 더한다.
                map1.put(genres[i], map1.get(genres[i]) + plays[i]);
            }
            else {
                map1.put(genres[i], plays[i]);
            }
            // index를 key로 하기 때문에, 중복 확인 불필요
            map2.put(i, genres[i]);
        }

        List<String> keySetList = new ArrayList<>(map1.keySet());
        keySetList.sort((o1, o2) -> map1.get(o2).compareTo(map1.get(o1)));

        for(String key : keySetList){

            ArrayList<Integer> tempList = new ArrayList<>();
            // index를 기반으로 genres와 같은 value값을 찾아 ArrayList에 저장한다.
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(map2.get(i))) {
                    tempList.add(i);
                }
            }
            if(tempList.size() < 2){ //값이 2개 미만 - 정렬 X
                list.add(tempList.get(0));
            }
            else { //값이 2개 이상 - 위에서 부터 순서대로 2개 추가
                //plays[index]를 기준 내림차순 정렬 O
                Integer[] sortList = tempList.toArray(new Integer[0]);
                Arrays.sort(sortList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer index1, Integer index2) {
                        return plays[index2] - plays[index1];
                    }
                });

                list.add(sortList[0]);
                list.add(sortList[1]);
            }

        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        //return answer;
        System.out.println(Arrays.toString(answer)); //[4, 1, 3, 0]
    }

}
