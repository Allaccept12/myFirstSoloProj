# myFirstSoloProj


블로그 개인 프로젝트 
Java, SpringBoot, Jpa, Mysql, Thymeleaf 사용


API 타임리프 특성상 메서드 GET, POST만 사용

| 기능     |   메서드 | URI  |
|:-------|------:|:----:|
| 게시글 조회 | GET | posts/  |
|   게시글 작성     |  POST    |  post/new    |
| 게시글 수정 | POST | post/{post_id}/edit |
| 게시글 삭제 | POST | post/{post_id}/delete |
| 댓글 등록  |   POST    |  comment/{post_id}    |
| 댓글 수정  |   POST    |   comment/{comment_id}/edit   |
| 댓글 삭제  |  POST     |   comment/{comment_id}/delete   |
