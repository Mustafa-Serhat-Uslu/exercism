class MicroBlog {
    public String truncate(String input) {
StringBuilder result = new StringBuilder();

input.codePoints()
     .limit(5)
     .forEach(result::appendCodePoint);

return result.toString();    }
}
