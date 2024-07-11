package week_1.rhdqngkwk90;

import java.util.*;

//자료구조 Hash 발표
public class ETC_HashMain {

    public static void main(String[] args) {
        /* 개념 */
        //Hash Table (해시 테이블)
        HashTable h = new HashTable(3);
        h.put("키1", "값1");
        h.put("키2", "값2");
        h.put("키3", "값3");
        h.put("키4", "값4");

        System.out.println("################ Hash Table ################");
        System.out.println("키1의 값 : "+h.get("키1"));
        System.out.println("키2의 값 : "+h.get("키2"));
        System.out.println("키3의 값 : "+h.get("키3"));
        System.out.println("키4의 값 : "+h.get("키4"));

        System.out.println("없는값 : "+h.get("키5"));

        /* Java에서 사용하는 Hash */

        //1. Hash Map (해시 맵)
        Map<String, Integer> m = new HashMap<>();
        m.put("키1",1);
        m.put("키2",2);
        m.put("키3",3);
        m.put("키4",4);
        m.put("키4",5);

        //주요 기능 설명
        Integer v = m.get("키3"); //값 가져오기
        boolean conKey = m.containsKey("키2"); //키가 존재하는지 확인
        //getOrDefault : get(key) 에서 key가 존재하지 않으면 null을 반환하는데, null 대신 기본 값을 반환하도록 할 수 있는 메소드
        m.put("키1", m.getOrDefault("키1", 0)); //키 값이 키1이면 값을 0으로 고정
        System.out.println("################ Hash Map ################");
        System.out.println(m);
        System.out.println("키3 값 : "+v+" 키2 존재 확인 : "+conKey);
        /*
         * {키1=1, 키3=3, 키2=2, 키4=5}
         * -> 순서 X             -> 중복 O 덮어써짐
         */

        //2. Hash Set (해시 셋)
        Set<String> s = new HashSet<>();
        s.add("값1");
        s.add("값2");
        s.add("값3");
        s.add("값4");
        s.add("값2");
        /*
        * 값2 -> 중복 X
        * 값3
        * 값4
        * 값1
        * -> 순서 X
        */
        
        //주요 기능 설명
        s.add("값5"); //값을 추가
        Set<String> s1 = new HashSet<>();
        s1.add("A");
        s1.add("C");
        s1.add("B");

        Set<String> s2 = new HashSet<>();
        s2.add("A");
        s2.add("B");
        s2.add("C");

        boolean eq1 = s.equals("값5"); //단일 값으로는 비교 X (false)
        boolean eq2 = s1.equals(s2); //Object로 비교 O (true)

        int hc = s.hashCode(); //해시코드
        boolean con = s.contains("값5"); //값을 포함하는지 확인
        /*
        데이터 삽입 - add(data)
        데이터 체크 - isContain(data)
        데이터 제거 - remove(data)
        셋 비우기 - clear()
        셋이 비었는지 체크 - isEmpty()
        모든 데이터 출력 - printAll()
         */
        
        System.out.println("################ Hash Set ################");
        for(String t : s) System.out.println(t);
        System.out.println("eq : "+eq1+" eq2 : "+eq2+" hc : "+hc+" con : "+con);
    }

    static class HashTable {

        //HashTable에 저장할 데이터를 담는다.
        class Node {
            String key;     //검색어(키)
            String value;   //검색 결과(값)

            // 생성자 생성
            public Node(String key, String value) {
                super();
                this.key = key;
                this.value = value;
            }

            // value를 가져온다. = get 함수
            String value() {
                return value;
            }

            // value를 저장한다. = set 함수
            void value(String value) {
                this.value = value;
            }

        }//Node 종료

        // 데이터를 저장할 리스트를 배열로 선언 -> 배열에 저장될 데이터의 타입을 LinkedList로 만든다.
        LinkedList<Node>[] data;

        //해시 테이블을 만드는 순간 배열방을 얼마만큼 고정된 방으로 만들지 미리 선언
        HashTable(int size) {
            this.data = new LinkedList[size];
        }

        //1) 해시 알고리즘 함수
        //해시 알고리즘을 갖고 있는 함수: 키를 받아서 해시코드를 반환한다.
        int getHashCode(String key) {
            int hashcode = 0;
            //키 값의 아스키코드를 가져와서 덧셈하는 해시 알고리즘
            for(char c: key.toCharArray()) {
                hashcode += c;
            }
            return hashcode;

        }//getHashCode 종료

        //2) hashcode를 받아서 배열 방의 index를 받은 함수
        int convertToIndex(int hashcode) {
            return hashcode % data.length;
        }//convertToIndex 종료


        //3) 검색 시, index로 배열 방을 찾은 이후에 배열 방 안에 노드가 여러개 존재 할 때, 검색 키로 해당 노드를 찾아오는 함수
        Node searchkey(LinkedList<Node> list, String key) {
            //배열 방이 null일때
            if(list == null) return null;
            //배열 방을 돈다.
            for(Node node: list) {
                //key값을 비교하면서 node를 찾는다.
                if(node.key.equals(key)) {
                    return node;
                }
            }
            return null;
        }//searchkey 종료

        //4) 데이터를 받아서 저장하는 함수
        void put(String key, String value) {
            int hashcode = getHashCode(key);        //해시 코드
            int index = convertToIndex(hashcode);   //배열 방 번호

            //확인 출력
            System.out.println("key : "+key +" hashcode : "+ hashcode +" index : " + index);

            //배열 방 번호를 이용해서 기존에 있는 데이터를 가져온다.
            LinkedList<Node> list = data[index];

            //배열이 null일 때.
            if(list == null) {
                list= new LinkedList<Node>();
                data[index] = list;
            }

            //배열방에 해당 키로 노드를 가져온다.
            Node node = searchkey(list, key);

            //노드가 null이면 데이터가 없다는 뜻이다.
            if(node == null) list.addLast(new Node(key, value)); //받아온 정보를 가지로 노드 객체를 생성한다
            else node.value(value); //노드가 null이 아닌 경우에는 해당 값으로 덮어쓰기해서 중복키 처리

        }//put 종료

        //5) 키를 가지고 데이터를 가져오는 함수
        String get(String key) {

            int hashcode = getHashCode(key);
            int index = convertToIndex(hashcode);
            LinkedList<Node> list = data[index];

            Node node = searchkey(list, key);

            return node == null? "Not found": node.value();

        }//get 종료

    }//HashTable 종료

}
