# 생태 정보 서비스 API
### 상세내용은 아래 API 정보를 확인해주세요.

* 조회 생태 관광지 중에 서비스 지역 컬럼에서 특정 지역에서 진행되는 프로그램명과 테마를 출력하는 API

        http://localhost:8080/program/theme/평창군
        
* 생태 정보 데이터에 "프로그램 소개” 컬럼에서 특정 문자열이 포함된 레코드에서 서비스지역 개수를 세어 출력하는 API

         http://localhost:8080/program/info/세계문화유산
        
* 모든 레코드에 프로그램 상세 정보를 읽어와서 입력 단어의 출현빈도수를 계산하여 출력하는 API

        http://localhost:8080/program/keyword-count/상원사

* 등록 json sample

        POST) http://localhost:8080/program/theme

        {
            "programName":"자연박물관",
            "theme":"문화생태체험",
            "serviceArea":"강원도 속초",
            "programTitle":"숲길, 만들기체험 등",
            "programDetail":"마을에서 놀면서 배우는 여행!"
        }


* 수정 json sample

        PUT) http://localhost:8080/program/theme/{programNo}
        예) PUT) http://localhost:8080/program/theme/1

        {
            "programName":"숲속여행",
            "theme":"문화생태체험",
            "serviceArea":"강원도 양양",
            "programTitle":"숲길, 걷기 등",
            "programDetail":"마음의 안정을 찾아가는 여행"
        }
