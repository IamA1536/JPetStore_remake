
document.getElementById("btn").onclick = function () {
    // ��ȡimgԪ��
    // Ϊ�����������������servlet, ����һ��Ҫ�ı�src
    document.getElementsByTagName("img")[0].src = "verifycode?time=" + new Date().getTime();
};