package ch06_클래스.ex07_return;

/**
 * return 문
 * - 메서드의 실행을 강제 종료하고, 호출한 곳으로 돌아간다.
 * - 호출한 곳으로 값을 되돌려준다.
 * 
 *   
 *   return[값];
 *   
 */
public class Car {
	// 필드선언
	int gas;
	
	// 리턴 값이 없는 메서드
	// 리턴 타입:void
	void setGas(int gas) {
		this.gas = gas;
	}
	
	//리턴 값이 있는 메서드
	// 리턴타입:boolean -> 메서드 이름은 isxxx- (관례)
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	};
	
	// 리턴 값 없는 메서드
	// 리턴타입:void
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다.(gas잔량:)"+gas+")");
				gas-=1;
			} else {
				System.out.println("멈춥니다.(gas잔량"+gas+")");
				return; // 메서드 종료
			}
		}
	}
	
}
