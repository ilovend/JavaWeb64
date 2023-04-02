package com.itheima.day01.pojos;

public class Emp {
    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;

    public Emp() {
    }

    public Emp(String name, Integer age, String image, String gender, String job) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        if ("1".equals(gender)) {
            return "男";
        } else if ("2".equals(gender)) {
            return "女";
        } else {
            return "未知";
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
