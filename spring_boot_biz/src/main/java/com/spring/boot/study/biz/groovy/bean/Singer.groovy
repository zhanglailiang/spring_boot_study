package com.spring.boot.study.biz.groovy.bean

class Singer {

    private Long id
    private String  firstName
    private Date birthDate
    private String ageCategory

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    Date getBirthDate() {
        return birthDate
    }

    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate
    }

    String getAgeCategory() {
        return ageCategory
    }

    void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory
    }


    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", ageCategory='" + ageCategory + '\'' +
                '}';
    }
}
