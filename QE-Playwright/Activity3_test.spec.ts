import {test, expect} from "@playwright/test"
test("Activity 3",async({page})=>{
    await page.goto("https://training-support.net/webelements/target-practice")
    console.log(await page.title());
    console.log(await page.getByRole('button',{name:"Cyan"}).textContent());
    console.log(await page.getByRole('heading',{name:"Heading #6"}).getAttribute("class"));
    let heading = await page.getByRole('heading',{name:"Heading #5"});
    console.log( await heading.evaluate((heading)=>
        window.getComputedStyle(heading).getPropertyValue("color")
    ));
    console.log(await page.getByRole('button',{name:"Pink"}).boundingBox());
});