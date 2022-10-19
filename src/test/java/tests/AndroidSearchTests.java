package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {


    @Test
    @DisplayName("Getting started wikipedia")
    void checkPrimaryTextsOnScreens() {

        step("Check text on first screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check text on second screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check text on third screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'continue' button", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Check text on fourth screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldHave(text("GET STARTED"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
    }

    @Test
    @DisplayName("Search")
    void searchTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }


    @Test
    @DisplayName("Search and open Roald Dahl page")
    void searchInPageTest() {

        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Roald dahl");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Open Roald Dahl page", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_feed_header")).first().click());
        step("Verify content found", () -> {
            $(AppiumBy.className("android.webkit.WebView")).$$(AppiumBy.className("android.widget.TextView")).first()
                    .shouldHave(text("Roald dahl"));
        });
    }
}


