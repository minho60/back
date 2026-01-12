package ch11_base모듈.sec09_Anotation;

import java.lang.reflect.Method;
/**
 * 애노테이션 설정 정보 이용
 * java.lang.reflect.AnnotatedElement
 * 	 - <TextendsAnnotation> T getAnnotation(Class<T> annotationClass) 
 * 		: 클래스, 메서드, 필드, 생성자 등에 선언된 특정 애노테이션을 런타임에 조회하여 반환
 * 		-> 지정한 애노테이션이 적용되어 있으면 애노테이션을 반환하고, 아니면 null 반환
 * 
 * java.lang.reflect.Method
 *   - public Object invoke(Object obj, Object... args)
 *   	: 리플렉션으로 얻은 Method 또는 Constructor를 런타임에 실제로 실행(호출)
 * 
 */
public class PrintAnnotationExample {
	public static void main(String[] args) throws Exception {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for(Method method : declaredMethods) {
			//PrintAnnotation 얻기
			PrintAnnotation printAnnotation = method.getAnnotation
					(PrintAnnotation.class);

			//설정 정보를 이용해서 선 출력
			printLine(printAnnotation);

			//메소드 호출
			method.invoke(new Service());
			
			//설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
		}
	}
	
	public static void printLine(PrintAnnotation printAnnotation) {
		if(printAnnotation != null) {
			//number 속성값 얻기
			int number = printAnnotation.number();
			for(int i=0; i<number; i++) {
				//value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}
}