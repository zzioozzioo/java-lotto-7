# java-lotto-precourse

***

## ⭐️ 핵심 기능

### 📌 입력 기능

- [ ] 로또 구입 금액 입력받기
- [ ] 당첨 번호 입력받기
- [ ] 보너스 번호 입력받기

### 📌 로또 발행 기능

- [ ] 구입 금액에 해당하는 만큼 로또 발행
- [ ] 로또 1장의 가격은 1,000원
- [ ] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 추첨
- [ ] 로또 번호의 숫자 범위는 1~45

### 📌 로또 당첨 확인 기능

- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교
- [ ] 5개의 번호가 일치하는 경우, 당첨 번호와 중복되지 않는 보너스 번호까지 비교

### 📌 계산 기능

- [ ] 사용자가 구매한 로또 번호와 당첨 번호의 일치 개수 계산
- [ ] 총 수익률 계산

### 📌 출력 기능

- [ ] 발행한 로또 수량 및 번호 오름차순 출력
- 당첨 내역 출력
    - [ ] 일치 개수별 로또 당첨 개수 출력
    - [ ] 수익률 출력

### 📌 예외 처리 기능

- 로또 구입 금액 입력 시
    - [ ] 값을 입력하지 않은 경우
    - [ ] 최소 구입 금액(로또 한 장의 값)과 최대 구입 가능 금액 사이의 숫자가 아닌 경우
    - [ ] 로또 한 장의 값으로 나누어 떨어지지 않는 경우

- 당첨 번호 입력 시
    - [ ] 값을 입력하지 않은 경우
    - [ ] 숫자가 아닌 경우
    - [ ] 번호가 여섯 개가 아닌 경우
    - 구분자가 유효하지 않은 경우
        - [ ] 구분자가 없는 경우
        - [ ] 구분자가 연속적으로 입력된 경우
    - [ ] 각 번호가 유효한 숫자 범위에 해당하지 않는 경우
    - [ ] 중복되는 번호가 존재할 경우

- 보너스 번호 입력 시
    - [ ] 값을 입력하지 않은 경우
    - [ ] 숫자가 아닌 경우
    - [ ] 유효한 숫자 범위에 해당하지 않는 경우
    - [ ] 당첨 번호와 중복되는 경우

- [ ] 잘못된 값 입력 시 "[ERROR]"로 시작하는 에러 메시지 출력 후 그 부분부터 다시 입력받기

***

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [ ] JDK-21 사용
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`
- [ ] `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [ ] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [ ] 프로그램 종료 시`System.exit()`를 호출 X
- [ ] 프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현(2까지만 허용)
- [ ] 3항 연산자 사용 X
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
- [ ] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현
- [ ] else 예약어 사용 X
- [ ] Java Enum을 적용하여 프로그램을 구현
- [ ] 구현한 기능에 대한 단위 테스트를 작성(단, UI(System.out, System.in, Scanner) 로직은 제외)
- [ ] 입출력을 담당하는 클래스를 별도로 구현

### 라이브러리 요구 사항

- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용