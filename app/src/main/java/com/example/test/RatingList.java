package com.example.test;
public class RatingList {
        private String  name;
        private String Email;
        private String hobby;
        public RatingList(){
        }
        public RatingList(String id, String comment, String ratestar) {
            this.name = id;
            this.Email = comment;
            this.hobby = ratestar;
        }
        public String getName() {
            return name;
        }
        public String getRollNo() {
            return Email;
        }
        public String getHobby() {
            return hobby;
        }
    }

