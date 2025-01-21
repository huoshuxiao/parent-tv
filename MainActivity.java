public class MainActivity extends AppCompatActivity {
    private ChannelDAO channelDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channelDAO = new ChannelDAO(this);

        // 插入真实的频道流数据
        channelDAO.addChannel("CCTV-1 综合频道", "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8", "新闻");
        channelDAO.addChannel("CCTV-2 财经频道", "http://ivi.bupt.edu.cn/hls/cctv2hd.m3u8", "财经");
        channelDAO.addChannel("CCTV-3 综艺频道", "http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8", "综艺");
        channelDAO.addChannel("CCTV-4 中文国际", "http://ivi.bupt.edu.cn/hls/cctv4hd.m3u8", "国际");
        channelDAO.addChannel("CCTV-5 体育频道", "http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8", "体育");
        channelDAO.addChannel("CCTV-6 电影频道", "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8", "电影");
        channelDAO.addChannel("湖南卫视", "rtmp://live.hkstv.hk.lxdns.com/live/hks", "娱乐");
        channelDAO.addChannel("浙江卫视", "rtmp://113.107.57.170:1935/live/zjtv", "娱乐");

        ListView listView = findViewById(R.id.channel_list);
        Cursor cursor = channelDAO.getAllChannels();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"name", "url"},
                new int[]{android.R.id.text1, android.R.id.text2},
                0
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            cursor.moveToPosition(position);
            String url = cursor.getString(cursor.getColumnIndex("url"));
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        });
    }
}
