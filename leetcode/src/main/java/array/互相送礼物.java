package array;

// 互相送礼物，不能得到自己的礼物
public class 互相送礼物 {

    public static void main(String[] args) {
        int[] gifts = new int[]{1,2,3,4,5,6,7};
        solution(gifts);
    }

    public static void solution(int[] gifts) {
        int[] result = new int[gifts.length];

        for (int i = 0; i < gifts.length; i++) {
            int random = (int)(  Math.random() * 100 );

            System.out.println(random);
        }
    }
}
