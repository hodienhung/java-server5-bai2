@GetMapping
public ResponseEntity<ApiResponse<PageResponse<CourseResponse>>> getCourses(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String sortBy,
        @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

    PageResponse<CourseResponse> result = courseService.getPagedCourses(page, size, sortBy, direction);

    ApiResponse<PageResponse<CourseResponse>> response = ApiResponse.<PageResponse<CourseResponse>>builder()
            .status(200)
            .message("ok")
            .data(result)
            .build();

    return ResponseEntity.ok(response);
}
