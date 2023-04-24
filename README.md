1. 새 프로젝트-> 
ext: build.gradle 에서 사용하는 전역변수 설정
apply plugin:의존성들을 적용할 건지 여부를 결정
repositories:각종 의존성을 어떤 원격 저장소에서 받을 건지 저장
dependencies:프로젝트 개발에 필요한 의존성들을 선언


2. 테스트 케이스 작성과 롬복 전환하기->
Gradle을 통해서 롬복 의존성 라이브러리를 추가해주었지만 동작하지 않았다
책의 gradle 버전보다 내 gradle 버전이 더 높아서 의존성 추가 방식이 바뀌었기 때문이었다
dependencies {
  implementation 'org.projectlombok:lombok'
}가아닌
dependencies {
  compileOnly 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'<img width="1440" alt="스크린샷 2023-04-24 오후 12 26 53" src="https://user-images.githubusercontent.com/68580993/233893596-becf5e15-40aa-4771-a623-726a7701d782.png">

}로 바꾸어주니 정상작동 하였다.

Test case 에서 assertThat 을  JUnit이 아닌 assertj를 사용하는 이유: 추가적 라이브러리가 안필요하고 자동완성이 더 확실히 지원됨.

롬복같은 경우 자주사용되는 코드인 getter setter 기본생성자 등을 어노테이션으로 자동 생성해준다.

3.JPA
객체지향형언어와 관계형 데이터베이스 간의 패러다임 불일치 문제로 jpa가 사용됨(상속, 1:N등의 객체 모델링을 데이터베이스로는 구현하기 어려움)
중간에서 패러다임을 일치시켜주는 역할을 함.

jpa는 인터페이스로 자바 표준명세서이다. 구현체가 필요하긴한데, 구현체교체의 용이성, 저장소 교체의 용이성을 위해 보통 spring data jpa라는 모듈을 이용한다.
