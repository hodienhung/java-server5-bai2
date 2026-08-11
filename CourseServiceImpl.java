@Override
public PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction) {
    if (page < 0) {
        page = 0;
    }

    String sortField = (sortBy == null || sortBy.trim().isEmpty()) ? "id" : sortBy;
    Sort sort = Sort.by(direction, sortField);
    Pageable pageable = PageRequest.of(page, size, sort);

    Page<Course> coursePage = courseRepository.findAll(pageable);

    // Map Page<Course> sang Page<CourseResponse>
    Page<CourseResponse> courseResponsePage = coursePage.map(courseMapper::toCourseResponse);

    // Chuyển đổi từ Page<CourseResponse> sang PageResponse<CourseResponse>
    return PageResponse.from(courseResponsePage);
}
