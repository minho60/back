package ch05_참조타입;

public class Ex06_다차원배열 {

	public static void main(String[] args) {
		// 2차원 배열 생성
		// 타입[][] 배열변수 = {{},...}
		int[][] scores = { { 80, 90, 96 }, { 76, 88 } };

		// 배열의 길이
		// 배열.length
		// {{값,값,값},{값,값}} -> 2
		// 배열명[인덱스].length
		System.out.println("1차원 배열 길이(반의 수): " + scores.length);
		System.out.println("2차원 배열 길이(첫 번째 반의 학생 수): " + scores[0].length);
		System.out.println("2차원 배열 길이(두 번째 반의 학생 수): " + scores[1].length);

		// 첫 번째 반의 세 번째 학생의 점수 읽기
		// 배열명[바깥배열인덱스][안쪽인덱스 배열]
		System.out.println("scores[0][2]: " + scores[0][2]);

		// 두 번째 반의 두 번째 학생의 점수 읽기
		System.out.println("scores[1][1]: " + scores[1][1]);

		// 첫 번째 반의 평균 점수 구하기
		int class1Sum = 0;
		for (int i = 0; i < scores[0].length; i++) {
			class1Sum += scores[0][i];
		}
		double class1Avg = (double) class1Sum / scores[0].length;
		System.out.println("첫 번째 반의 평균 점수: " + class1Avg);

		// 두 번째 반의 평균 점수 구하기
		int class2Sum = 0;
		for (int i = 0; i < scores[1].length; i++) {
			class2Sum += scores[1][i];
		}
		double class2Avg = (double) class2Sum / scores[1].length;
		System.out.println("두 번째 반의 평균 점수: " + class2Avg);

		// 전체 학생의 평균 점수 구하기
		int totalStudent = 0;
		int totalSum = 0;
		for (int i = 0; i < scores.length; i++) { // 반의 수만큼 반복
			totalStudent += scores[i].length; // 반의 학생 수 합산
			for (int k = 0; k < scores[i].length; k++) { // 해당 반의 학생 수만큼 반복
				totalSum += scores[i][k]; // 학생 점수 합산
			}
		}
		double totalAvg = (double) totalSum / totalStudent;
		System.out.println("전체 학생의 평균 점수: " + totalAvg);

		System.out.println("\n");

		// 각 반의 학생 수가 3명으로 동일할 경우 점수 저장을 위한 2차원 배열 생성
		int[][] mathScores = new int[2][3];
		// 배열 항목 초기값 출력
		// 반의 수만큼 반복
		for (int i = 0; i < mathScores.length; i++) { 
			// 해당 반의 학생 수만큼 반복
			for (int k = 0; k < mathScores[i].length; k++) { 
				System.out.println("mathScores[" + i + "][" + k + "]: " + mathScores[i][k]);
			}
		}
		System.out.println();
		// 배열 항목 값 변경
		mathScores[0][0] = 80;
		mathScores[0][1] = 83;
		mathScores[0][2] = 85;
		mathScores[1][0] = 86;
		mathScores[1][1] = 90;
		mathScores[1][2] = 92;
		// 전체 학생의 수학 평균 구하기
		
		int totalMathSum = 0;
		for (int i = 0; i < mathScores.length; i++) {
			totalStudent += mathScores[i].length; // 반의 학생 수 합산
			for (int k = 0; k < mathScores[i].length; k++) { // 해당 반의 학생 수만큼 반복
				totalMathSum += mathScores[i][k]; // 학생 점수 합산
			}
		}
		double totalMathAvg = (double) totalMathSum / totalStudent;
		System.out.println("전체 학생의 수학 평균 점수: " + totalMathAvg);
		System.out.println();

		// 각 반의 학생 수가 다를 경우 점수 저장을 위한 2차원 배열 생성
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		// 배열 항목 초기값 출력
		for (int i = 0; i < englishScores.length; i++) { // 반의 수만큼 반복
			for (int k = 0; k < englishScores[i].length; k++) { // 해당 반의 학생 수만큼 반복
				System.out.println("englishScores[" + i + "][" + k + "]: " + englishScores[i][k]);
			}
		}
		System.out.println();
		// 배열 항목 값 변경
		englishScores[0][0] = 90;
		englishScores[0][1] = 91;
		englishScores[1][0] = 92;
		englishScores[1][1] = 93;
		englishScores[1][2] = 94;
		// 전체 학생의 영어 평균 구하기
		totalStudent = 0;
		int totalEnglishSum = 0;
		for (int i = 0; i < englishScores.length; i++) { // 반의 수만큼 반복
			totalStudent += englishScores[i].length; // 반의 학생 수 합산
			for (int k = 0; k < englishScores[i].length; k++) { // 해당 반의 학생 수만큼 반복
				totalEnglishSum += englishScores[i][k]; // 학생 점수 합산
			}
		}
		double totalEnglishAvg = (double) totalEnglishSum / totalStudent;
		System.out.println("전체 학생의 영어 평균 점수: " + totalEnglishAvg);

	}

}
