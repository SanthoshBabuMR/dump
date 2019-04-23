package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.partner.Shareable;

public class WebLink extends Bookmark implements Shareable {
    @Override
    public String toString() {
        return "WebLink [url=" + url + ", host=" + host + "]";
    }

    private String url;
    private String host;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isKidFriendlyEligible() {
        System.out.println(url);
        return !url.contains("porn") && !getTitle().contains("porn") && !host.contains("adult");
    }

    @Override
    public String getItemData() {
        StringBuilder sb = new StringBuilder();
        sb.append("<item>");
        sb.append("<type>WebLink</type>");
        sb.append("<title>").append(getTitle()).append("</type>");
        sb.append("<url>").append(url).append("</url>");
        sb.append("<host>").append(host).append("</host>");
        sb.append("</item>");
        return sb.toString();
    }

}
