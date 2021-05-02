package extends_examples;

/**
 * 앞서 상속을 하는 이유를 다음 한문장으로 소개할 수 있다.
 * 연관된 일련의 클래스들에 대해 공통적인 규약을 정의할 수 있다.
 */
public class MyFriends {
    public static void main(String[] args) {
        UnivFreind[] univFreinds = new UnivFreind[5];
        int ucnt = 0;

        ComFriend[] comFriends = new ComFriend[5];
        int ccnt = 0;

        // 대학 동창의 정보 저장
        univFreinds[ucnt++] = new UnivFreind("LEE", "Computer", "010-333-555");
        univFreinds[ucnt++] = new UnivFreind("SEO", "Electronics", "010-222-444");

        // 직장 동료의 정보 저장
        comFriends[ccnt++] = new ComFriend("YOON", "R&D 1", "02-123-999");
        comFriends[ccnt++] = new ComFriend("PARK", "R&D 2", "02-321-777");


        // 모든 동창 및 동료의 전체 출력
        for (int i = 0; i < ucnt; i++) {
            univFreinds[i].showInfo(); // UnivFreind 객체 배열에서 showInfo 함수를 호출하여 저장된 값을 출력한다.
            System.out.println();
        }

        for (int i = 0; i < ccnt; i++) {
            comFriends[i].showInfo(); // comFriends 객체 배열에서 showInfo 함수를 호출하여 저장된 값을 출력한다.
            System.out.println();
        }

    }
}

class UnivFreind {
    private String name;
    private String major;
    private String phone;

    public UnivFreind(String name, String major, String phone) {
        this.name = name;
        this.major = major;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("이름 : " + this.name);
        System.out.println("전공 : " + this.major);
        System.out.println("전화 : " + this.phone);
    }
}

class ComFriend {
    private String name;
    private String department;
    private String phone;

    public ComFriend(String name, String department, String phone) {
        this.name = name;
        this.department = department;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("부서 : " + department);
        System.out.println("전화 : " + phone);
    }
}
