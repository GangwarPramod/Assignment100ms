package com100msDTO;

import lombok.Getter;

@Getter
public class ResolutionPojo {
    private int width;
    private int height;
    public ResolutionPojo(int width, int height) {
        this.width = width;
        this.height = height;
    }


     public static ResolutionBuilder builder() {
       return new ResolutionBuilder();
   }
   public static class ResolutionBuilder {
      public ResolutionPojo build(){
          return new ResolutionPojo(width,height);
      }
        public int getWidth() {
            return width;
        }

        public ResolutionBuilder setWidth(int width) {
            this.width = width;
            return this;
        }

        public int getHeight() {
            return height;
        }

        public ResolutionBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        private int width;
        private int height;

        }
    }


