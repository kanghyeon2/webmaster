package chap07;

public class KumhoTire extends Tire {
	// 필드

	// 생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	// 메소드
	@Override
	public boolean roll() {
		accRotation++;
		if (accRotation < maxRotation) {
			System.out.println(location + "KumhoTire수명" + (maxRotation - accRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + "KumhoTire펑크 ***");
			return false;
		}
	}
}
