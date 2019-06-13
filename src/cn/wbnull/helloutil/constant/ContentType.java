package cn.wbnull.helloutil.constant;

/**
 * Content-Type
 *
 * @author dukunbiao(null) 2018-09-15
 *         https://github.com/dkbnull/Util
 */
public enum ContentType {

    MULTIPART_FORM_DATA("multipart/form-data"),
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
    TEXT_PLAIN("text/plain"),
    APPLICATION_JSON("application/json"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    APPLICATION_XML("application/xml"),
    TEXT_XML("text/xml"),
    TEXT_JAVASCRIPT("text/javascript"),
    TEXT_HTML("text/html");

    private String contentType;

    ContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return contentType;
    }
}
