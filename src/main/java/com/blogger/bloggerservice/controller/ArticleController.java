package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.service.ArticleService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 上传博客文章
     * 接口名 /sys/uploadArticle.json
     * 入参
     * articleTypeId            Int|M|博客分类id
     * articleTitle             String|M|博客标题
     * articleContent           String|M|博客内容
     * userId                   Int|M|用户标号
     *
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     *
     *
     * 示例
     *
     *
     * @return
     */
    @RequestMapping(value = "/uploadArticle.json", method = RequestMethod.POST)
    @ResponseBody
    public String uploadArticle(@Validated(value = ArticleForm.UploadArticle.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.uploadArticle(articleForm));
    }

    /**
     * 获取博客列表
     * 接口名 /sys/getBlogList.json
     * 入参
     * pageIndex            Int|M|页码
     * pageSize             Int|M|页数
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     *  blogList            List
     *  currentPage         Int|M|当前页
     *  count               Int|M|总条数
     *
     * 示例
     * {
     * 	"code": "1000",
     * 	"message": "成功",
     * 	"data": {
     * 		"count": 19,
     * 		"currentPage": 1,
     * 		"blogList": [
     *                        {
     * 				"id": 1,
     * 				"articleTypeId": 1,
     * 				"articleTitle": "武汉封城第六天:一夜之间的暴发",
     * 				"articePic": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581590990616&di=dff6f4f5e586892371b876b6c1728548&imgtype=0&src=http%3A%2F%2Ft7.baidu.com%2Fit%2Fu%3D3616242789%2C1098670747%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D900%26h%3D1350",
     * 				"articleContent": "<div class=\"_16zCst\"><h1 class=\"_2zeTMs\" title=\"倪妮和井柏然分手暴露一个真相：“这种姑娘只能恋爱，不能结婚？”\">倪妮和井柏然分手暴露一个真相：“这种姑娘只能恋爱，不能结婚？”</h1></div><div class=\"_26qd_C\"><a class=\"qzhJKO\" href=\"/u/4179f0c38661\"><span class=\"_22gUMi\">别人家的七七</span></a><button data-locale=\"zh-CN\" type=\"button\" class=\"_1OyPqC _3Mi9q9\"><span>关注</span></button><button type=\"button\" class=\"_1OyPqC _3Mi9q9 _1YbC5u\"><span>赞赏支持</span></button></div></div></div></div><div class=\"VYwngI\"></div></header><div class=\"_21bLU4 _3kbg6I\"><div class=\"_3VRLsv\" role=\"main\"><div class=\"_gp-ck\"><section class=\"ouvJEz\"><h1 class=\"_1RuRku\">倪妮和井柏然分手暴露一个真相：“这种姑娘只能恋爱，不能结婚？”</h1><article class=\"_2rhmJa\"><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 700px; max-height: 613px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 56.76%;\"></div>\r\n<div class=\"image-view\" data-width=\"1080\" data-height=\"613\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-6ebb44efc4871f6f.jpg\" data-original-width=\"1080\" data-original-height=\"613\" data-original-format=\"image/jpeg\" data-original-filesize=\"210294\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>/1/</p><p><b>之前刷手机的时候看到倪妮上热搜排行榜第一的位置，点进去一看原来是她参加金鸡百花电影节要过安检的生图给流传出来，然后立马引起广大网友们热烈讨论。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 700px; max-height: 479px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 53.05%;\"></div>\r\n<div class=\"image-view\" data-width=\"903\" data-height=\"479\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-47c264c8d35dd31d\" data-original-width=\"903\" data-original-height=\"479\" data-original-format=\"image/png\" data-original-filesize=\"45330\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>小图好像看不太出什么，没关系，下面再单独放一张比较高清的生图给大家品一品。</p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 700px; max-height: 530px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 57.36%;\"></div>\r\n<div class=\"image-view\" data-width=\"924\" data-height=\"530\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-bc4f26a2ed3eb790\" data-original-width=\"924\" data-original-height=\"530\" data-original-format=\"image/jpeg\" data-original-filesize=\"38267\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>说实话，倪妮的生图的确很“可”，首先她天生自带的冷白皮和高挑身材，合影的时候已经可以干掉一大批人，其次再加上她自己本身自带一股“冷艳”高级感的气质。（局外话：我个人还蛮欣赏这种颜的~）</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 440px; max-height: 1515px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 216.36%;\"></div>\r\n<div class=\"image-view\" data-width=\"440\" data-height=\"952\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-12f36461098d074d\" data-original-width=\"440\" data-original-height=\"952\" data-original-format=\"image/jpeg\" data-original-filesize=\"37000\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>所以不仅有很多男生们觉得她长得很漂亮，而且就连身为同性的女生们也很吃她的颜。</p><p><b>评论底下的粉丝网友们也纷纷夸赞她气场全开、生图绝了……大概是因此荣获“生图杀手”的称号而上了热搜。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 700px; max-height: 267px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 26.41%;\"></div>\r\n<div class=\"image-view\" data-width=\"1011\" data-height=\"267\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-65b1676178a87618\" data-original-width=\"1011\" data-original-height=\"267\" data-original-format=\"image/png\" data-original-filesize=\"20162\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>/2/</p><p><b>说起倪妮，她为人比较低调，性格温柔，对待媒体粉丝们朋友也很友好。这些年在娱乐圈除了谈过两段恋爱无疾而终外，好像也没什么黑点。</b></p><p>因为前两段恋爱交往对象都是圈内有名男星小生，所以恋情开始和结束都被大众们所熟知，一段恋爱的前任男友冯绍峰已经告别单身，和赵丽颖因戏结缘，弄假成真结为“真夫妻”，年初的时候还公布喜添一子的好消息。</p><p>而另一段恋爱和井柏然是在去年七月份的时候，双方一起官宣和平分手，但据说好像五月份就已经结束恋爱关系。</p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 642px; max-height: 475px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 73.99%;\"></div>\r\n<div class=\"image-view\" data-width=\"642\" data-height=\"475\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-b5090b659c7097e6\" data-original-width=\"642\" data-original-height=\"475\" data-original-format=\"image/jpeg\" data-original-filesize=\"26145\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 643px; max-height: 461px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 71.7%;\"></div>\r\n<div class=\"image-view\" data-width=\"643\" data-height=\"461\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-acbebeecd06e7070\" data-original-width=\"643\" data-original-height=\"461\" data-original-format=\"image/jpeg\" data-original-filesize=\"24673\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>记得不只我被这个消息震惊到，连他们俩很多粉丝朋友们也因此纷纷感到惋惜和遗憾，毕竟这一对俊男靓女的结合看起来多么的亮眼。</b></p><p>当时微博热搜留言随便一刷都是：</p><p>“我还以为他们会走到结婚。”</p><p>“看到井柏然倪妮分手，感觉遇到对的人一直走下去好难呀。”</p><p>“我看得好心碎，两个人各个方面都超级配。那些庆幸分手的人，你们偶像以后恐怕再也找不到这样登对的人了。”</p><p>是啊，即便是身为路人的我也觉得好生可惜，多么养眼般配的一对金童玉女，就这样被一纸公示宣判“剧终”。</p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 600px; max-height: 450px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 75.0%;\"></div>\r\n<div class=\"image-view\" data-width=\"600\" data-height=\"450\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-abfa305084c095eb\" data-original-width=\"600\" data-original-height=\"450\" data-original-format=\"image/jpeg\" data-original-filesize=\"27401\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>/3/</p><p><b>特别是当时的倪妮正好处于“三十而立”的年纪，要是放在我们普通人的身边依然已经有点“催婚”味道，而井柏然刚好少她一岁。</b></p><p>因为俩人的颜值和人气都非常高，当红小花小生的组合一举一动都牵动媒体，他们俩的恋情自然是备受关注的。</p><p>在这样的情况下，随着俩人恋情甜蜜且稳定的发展，很多人都开始觉得，是时候结婚了吧？是时候修成正果了吧？”</p><p><b>遗憾的是，粉丝们并没有等来俩人结婚的好消息，而是等来了官宣的分手。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 537px; max-height: 667px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 124.21%;\"></div>\r\n<div class=\"image-view\" data-width=\"537\" data-height=\"667\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-844e1b50439414a2\" data-original-width=\"537\" data-original-height=\"667\" data-original-format=\"image/jpeg\" data-original-filesize=\"52531\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>或许是倪妮为人太过于低调的，不像娱乐圈其他情侣那样频繁互动和秀恩爱，之前跟冯绍峰那段恋情也是以和平分手而终结。</b></p><p>每次分手都分得太过于安静温和，也没有什么具体原因，因此出现很多的声音，甚至还被质疑是预谋的“捆绑炒作”“合约情侣”。（不过俩人工作室第一时间出来否认这个说法）</p><p>为什么我对这件事印象这么清楚，是因为记得当时他俩分手的消息一传开的时候，我的微信里就有个sb博主不分时宜发了条朋友圈原话大概就是：</p><p>看看，我说什么来着，倪妮与冯绍峰分了，与井柏然也分了，感觉像她这种姑娘看起来就是<b>比较适合谈恋爱，注定很难结婚？（真的不是故意黑她，不喜勿喷）</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 700px; max-height: 893px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 127.55000000000001%;\"></div>\r\n<div class=\"image-view\" data-width=\"715\" data-height=\"912\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-0339efe33e37e608\" data-original-width=\"715\" data-original-height=\"912\" data-original-format=\"image/jpeg\" data-original-filesize=\"63817\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>这话一听不止我，很多倪妮粉还有不是倪妮粉的人都看不太过去，质问他人家倪妮这种女孩怎么了？怎么就只是适合恋爱了？怎么就注定很难结婚了？</b></p><p>难道不是，本来人家分手已经在风口浪尖上，态度已经表明希望好聚好散，你倒好，跳出来说人家姑娘不是，踩人家一脚，忍不住让人怀疑你有什么不纯良的目的。</p><p>这人也怂一看引起众怒，吓得立马把这条朋友圈删了。</p><p>老实说，什么是看起来就适合恋爱的女孩，什么是看起来就适合结婚的女孩，谁敢给个肯定回答。</p><p>可能那个看起来像个不食人间烟火的姑娘，私底下她就是很擅长家务，可能那个看起来贤良淑德像个贤妻良母的姑娘，人家就是连洗个碗都不会，反正不要以貌取人，更不要无根无据就在那里妄下定论。</p><p><b>这种随随便便就胡乱给女孩贴标签的怂男真的太讨厌了。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 500px; max-height: 358px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 71.6%;\"></div>\r\n<div class=\"image-view\" data-width=\"500\" data-height=\"358\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-fac9d9036334dd74\" data-original-width=\"500\" data-original-height=\"358\" data-original-format=\"image/jpeg\" data-original-filesize=\"33390\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p>/4/</p><p><b>然而，生活中存在太多诸如此类的偏见，比如偏激长辈、直男癌口中经常脱口而出：</b></p><p>“她太能花钱了不适合过日子。”</p><p>“她对外表这么讲究只适合做女友”</p><p>“她连个顿饭都做不好怎么可以结婚”</p><p>这些言论仿佛都在女孩们贴标签，归类别，你就得按照我的想法来，活成我想要的样子，变成家庭的附属品，是男人的附属品，更甚还有那种非要你赚的钱都花在家庭老公孩子公公婆婆身上才算贤惠，才叫顾家？</p><p>花在自己身上，买限量款的口红，买高档的香水，买名牌的包包，都会被这认为不可理解，都被贴上“你这样将来是没有男人敢娶的”的标签。</p><p><b>不然只能轮为适合谈个恋爱，要结婚那就不行了，细思极恐。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 600px; max-height: 369px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 61.5%;\"></div>\r\n<div class=\"image-view\" data-width=\"600\" data-height=\"369\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-5f27d3b20862c3a3\" data-original-width=\"600\" data-original-height=\"369\" data-original-format=\"image/jpeg\" data-original-filesize=\"31412\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>要知道现在很多女孩努力工作和生活，不攀附、不妥协，凭着自己的努力活成了让人羡慕的样子，将自己变得优秀且精致。</b></p><p>不是为了让自己变成所谓男人眼中“适合结婚的女孩”，更不是为了让自己迎合某个人的喜好去改变自己，而是单纯因为深爱自己，想要自己活得开心，变得更好。</p><p>王尔德也说了，一个懂得恰如其分地热爱自己的人，一定能恰如其分地做好其他一切事情。</p><p><b>所以亲爱的姑娘们，别太在乎他人的眼光，别太在意他人的眼色，永远记得，好好爱自己，取悦自己，为自己而活才是正经事。</b></p><div class=\"image-package\">\r\n<div class=\"image-container\" style=\"max-width: 590px; max-height: 601px;\">\r\n<div class=\"image-container-fill\" style=\"padding-bottom: 101.86%;\"></div>\r\n<div class=\"image-view\" data-width=\"590\" data-height=\"601\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/6001242-a3007be95cf5ef77\" data-original-width=\"590\" data-original-height=\"601\" data-original-format=\"image/jpeg\" data-original-filesize=\"38854\"></div>\r\n</div>\r\n<div class=\"image-caption\"></div>\r\n</div><p><b>你的自我价值，从来不需要由男人赋予，更不需要被人贴标签。</b></p><p>假如以后再有人对你说这种类似于“你只适合谈恋爱”或“你不适合结婚”这种话。</p><p><b>你直接请ta滚出你的世界，因为这等凡夫俗子是不适合跟你这种仙女交朋友甚至恋爱结婚，你值得被更好更懂得尊重女生的男人所温柔对待。</b></p><p>-end-</p></article><div></div><div class=\"_19DgIp\" style=\"margin-top:24px;margin-bottom:24px\"></div></section><section class=\"sFiE8U\" aria-label=\"google-ad\"><ins class=\"adsbygoogle\" style=\"display:inline-block;width:730px;height:114px\" data-ad-client=\"ca-pub-3077285224019295\" data-ad-slot=\"2979144022\"></ins></section><div id=\"note-page-comment\"><div class=\"lazyload-placeholder\"></div></div><section class=\"ouvJEz\"><h3 class=\"QxT4hD\"><span>被以下专题收入，发现更多相似内容</span></h3><div class=\"_2Nttfz\"><div class=\"_3s5t0Q _1lsejJ\" role=\"button\" tabindex=\"-1\" aria-label=\"收入我的专题\"><i aria-label=\"ic-plus\" class=\"anticon\"><svg width=\"1em\" height=\"1em\" fill=\"currentColor\" aria-hidden=\"true\" focusable=\"false\" class=\"\"><use xlink:href=\"#ic-plus\"></use></svg></i><span class=\"_2-Djqu\">收入我的专题</span></div></div><div class=\"_19DgIp\" style=\"margin-top:32px;margin-bottom:32px\"></div><h3 class=\"QxT4hD\"><span>推荐阅读</span><a class=\"_29KFEa _1OhGeD\" href=\"/\" target=\"_blank\" rel=\"noopener noreferrer\">更多精彩内容<i aria-label=\"ic-right\" class=\"anticon\"><svg width=\"1em\" height=\"1em\" fill=\"currentColor\" aria-hidden=\"true\" focusable=\"false\" class=\"\"><use xlink:href=\"#ic-right\"></use></svg></i></a></h3><ul class=\"_1iTR78\"><li class=\"_11jppn\"><div class=\"JB6qEE\"><div class=\"em6wEs\" title=\"井柏然倪妮分手：相爱时请用力，分手时请体面！\" role=\"heading\" aria-level=\"4\"><a class=\"_2voXH8 _1OhGeD\" href=\"/p/79984373c8d6\" target=\"_blank\" rel=\"noopener noreferrer\">井柏然倪妮分手：相爱时请用力，分手时请体面！</a></div><div class=\"_3fvgn4\">井柏然与倪妮一直被CP粉们亲切地称为娱乐圈里行走的蜜罐，很不幸，昨天，这对甜过初恋的蜜罐彻底碎了。 7月5日上午，...</div><div class=\"_1pJt6F\"><a class=\"_3IWz1q _1OhGeD\" href=\"/u/a626ba39cadb\" target=\"_blank\" rel=\"noopener noreferrer\"><span class=\"_3tPsL6\">晏耀飞</span></a><span class=\"_31hjBO\">阅读<!-- --> <!-- -->434</span><span class=\"_31hjBO\">评论<!-- --> <!-- -->0</span><span class=\"_31hjBO\">赞<!-- --> <!-- -->10</span></div></div><a class=\"_10MMAm _1OhGeD\" href=\"/p/79984373c8d6\" target=\"_blank\" rel=\"noopener noreferrer\"></a></li><li class=\"_11jppn\"><div class=\"JB6qEE\"><div class=\"em6wEs\" title=\"井柏然倪妮宣告分手：分手应该体面，谁都不要说抱歉。缘分这事儿，莫负对方就好。\" role=\"heading\" aria-level=\"4\"><a class=\"_2voXH8 _1OhGeD\" href=\"/p/449ee8c50327\" target=\"_blank\" rel=\"noopener noreferrer\">井柏然倪妮宣告分手：分手应该体面，谁都不要说抱歉。缘分这事儿，莫负对方就好。</a></div><div class=\"_3fvgn4\">​两个成年人心照不宣的选择走到这里就可以了，接下来的路希望你好好的走，也许你会遇见你想呵护的人，也许我会好好享受生...</div><div class=\"_1pJt6F\"><a class=\"_3IWz1q _1OhGeD\" href=\"/u/cdd0aff48791\" target=\"_blank\" rel=\"noopener noreferrer\"><span class=\"_3tPsL6\">则无鱼</span></a><span class=\"_31hjBO\">阅读<!-- --> <!-- -->112</span><span class=\"_31hjBO\">评论<!-- --> <!-- -->0</span><span class=\"_31hjBO\">赞<!-- --> <!-- -->1</span></div></div><a class=\"_10MMAm _1OhGeD\" href=\"/p/449ee8c50327\" target=\"_blank\" rel=\"noopener noreferrer\"></a></li><li class=\"_11jppn\"><div class=\"JB6qEE\"><div class=\"em6wEs\" title=\"倪妮井柏然分手了！倪妮希望大家不要太了解她\" role=\"heading\" aria-level=\"4\"><a class=\"_2voXH8 _1OhGeD\" href=\"/p/1d989baf159f\" target=\"_blank\" rel=\"noopener noreferrer\">倪妮井柏然分手了！倪妮希望大家不要太了解她</a></div><div class=\"_3fvgn4\">“我希望大家记住的、喜欢我的东西永远都是在银幕上的，我不希望大家太了解我。”——倪妮 /配一脸的倪妮井柏然分手了/...</div><div class=\"_1pJt6F\"><a class=\"_3IWz1q _1OhGeD\" href=\"/u/37914a94748c\" target=\"_blank\" rel=\"noopener noreferrer\"><span class=\"_3tPsL6\">热心网友小Z</span></a><span class=\"_31hjBO\">阅读<!-- --> <!-- -->100</span><span class=\"_31hjBO\">评论<!-- --> <!-- -->0</span><span class=\"_31hjBO\">赞<!-- --> <!-- -->0</span></div></div><a class=\"_10MMAm _1OhGeD\" href=\"/p/1d989baf159f\" target=\"_blank\" rel=\"noopener noreferrer\"></a></li><li class=\"_11jppn\"><div class=\"JB6qEE\"><div class=\"em6wEs\" title=\"井柏然倪妮被传分手？网友称合约恋人，倪妮：慢慢学会跟自己独处\" role=\"heading\" aria-level=\"4\"><a class=\"_2voXH8 _1OhGeD\" href=\"/p/f787a9cca09a\" target=\"_blank\" rel=\"noopener noreferrer\">井柏然倪妮被传分手？网友称合约恋人，倪妮：慢慢学会跟自己独处</a></div><div class=\"_3fvgn4\">这几天，井柏然和倪妮被网友爆出分手的消息，之后小料一直不断的被曝光，和前男友冯绍峰之间的一些事也被爆了出来，甚至还...</div><div class=\"_1pJt6F\"><a class=\"_3IWz1q _1OhGeD\" href=\"/u/50c9bb39237a\" target=\"_blank\" rel=\"noopener noreferrer\"><span class=\"_3tPsL6\">拉米拉科技集团</span></a><span class=\"_31hjBO\">阅读<!-- --> <!-- -->40</span><span class=\"_31hjBO\">评论<!-- --> <!-- -->0</span><span class=\"_31hjBO\">赞<!-- --> <!-- -->0</span></div></div><a class=\"_10MMAm _1OhGeD\" href=\"/p/f787a9cca09a\" target=\"_blank\" rel=\"noopener noreferrer\"></a></li><li class=\"_11jppn\"><div class=\"JB6qEE\"><div class=\"em6wEs\" title=\"梦\" role=\"heading\" aria-level=\"4\"><a class=\"_2voXH8 _1OhGeD\" href=\"/p/8931e5e06d72\" target=\"_blank\" rel=\"noopener noreferrer\">梦</a></div><div class=\"_3fvgn4\">我梦到了死亡 好可怕 ，梦到了我出了车祸死了，只有妈妈看得到我，一直哭一直哭…其实死亡并不可怕，可怕的是见不到最珍...</div><div class=\"_1pJt6F\"><a class=\"_3IWz1q _1OhGeD\" href=\"/u/9a98685f9e0a\" target=\"_blank\" rel=\"noopener noreferrer\"><span class=\"_3tPsL6\">美少女章鱼哥</span></a><span class=\"_31hjBO\">阅读",
     * 				"articleInfo": "恶趣味请问,嗨，我是十八这是2020年简书的第1篇推送愿你足够努力，内外兼修自由无忧，认真且酷 01 韩雪说:“我喜欢看过世界的男生，不喜欢对世界还蠢蠢欲动...",
     * 				"articleClick": 2,
     * 				"articleReplay": 34,
     * 				"articleFrom": "32",
     * 				"userId": 12,
     * 				"userName": "张三",
     * 				"createdAt": "Feb 13, 2020 4:10:41 PM",
     * 				"updatedAt": "Feb 13, 2020 4:10:41 PM"
     *            },
     *            {
     * 				"id": 2,
     * 				"articleTypeId": 1,
     * 				"articleTitle": "成为数据分析师，抢占互联网红利！",
     * 				"articePic": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581590990616&di=dff6f4f5e586892371b876b6c1728548&imgtype=0&src=http%3A%2F%2Ft7.baidu.com%2Fit%2Fu%3D3616242789%2C1098670747%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D900%26h%3D1350",
     * 				"articleContent": "articleContent",
     * 				"articleInfo": "一段视频，三观碎了一地。 一位贤惠的姑娘贴心做好晚饭。 邀请闺蜜来家做客。 划重点： 门没关，你自己上来吧。 于此同时，自己则跟男朋友在床上干柴...",
     * 				"articleClick": 4,
     * 				"articleReplay": 76,
     * 				"userId": 12,
     * 				"userName": "里斯",
     * 				"createdAt": "Feb 13, 2020 4:10:50 PM",
     * 				"updatedAt": "Feb 13, 2020 4:10:50 PM"
     *            }
     * 		]
     * 	}
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getBlogList.json", method = RequestMethod.POST)
    @ResponseBody
    public String getBlogList(@Validated(value = ArticleForm.BlogList.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.getBlogList(articleForm));
    }

    /**
     * 获取博客类型
     * 接口名 /sys/getArticleType.json
     * 入参uploadArticle
     * 无
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     *
     * 示例
     * {
     * 	"code": "1000",
     * 	"message": "成功",
     * 	"data": [{
     * 		"name": "生活",
     * 		"id": 2
     *        }, {
     * 		"name": "技术",
     * 		"id": 1
     *    }, {
     * 		"name": "福利",
     * 		"id": 3
     *    }]
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getArticleType.json", method = RequestMethod.POST)
    @ResponseBody
    public String getArticleType() {
        return JsonUtils.objectToString(articleService.getArticleType());
    }

}
