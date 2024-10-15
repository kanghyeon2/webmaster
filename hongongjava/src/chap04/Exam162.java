package chap04;

public class Exam162 {

	public static void main(String[] args) {
		//주사위 2개를 던져서 합이 5가 되면 종료 - gameover-
		//5가 아니면 (1,3) 주사위 눈 표시
		//몇번만에 나온지 체크
		
			int count = 0;
			while(true) {
			int dice1 = (int)(Math.random()*6)+1;		
			int dice2 = (int)(Math.random()*6)+1;
			count++;
			System.out.printf("(%d, %d) \t", dice1, dice2);
			if(dice1 + dice2 == 5) {
				System.out.println("\n" + count + "번 gameover");
				break;
			}
		}
	
		// 주사위 눈이 1이면 1등 ~ 6이면 6등
			int dice3 = (int)(Math.random()*6)+1;
			switch(dice3) {
			case 1:
				System.out.println("1등");
				break;
			case 2:
				System.out.println("2등");
				break;
			case 3:
				System.out.println("3등");
				break;
			case 4:
				System.out.println("4등");
				break;
			case 5:
				System.out.println("5등");
				break;
			default:
				System.out.println("6등");
				break;
			}
		
			//50에서 100까지 수를 발생
			//90이상이면 A, 80이상이면 B, 70이상이면 C, 60이상이면 D
			
			int num = (int)(Math.random()*51)+50;
			switch(num/10*10) {
			case 100 :
			case 90 :
				System.out.println("A"); break;
			case 80 :
				System.out.println("B"); break;
			case 70 :
				System.out.println("C"); break;
			case 60 :
				System.out.println("D"); break;
			case 50 :
				System.out.println("F"); break;
			}
			System.out.println(num);
				
		}
			
			
	}


