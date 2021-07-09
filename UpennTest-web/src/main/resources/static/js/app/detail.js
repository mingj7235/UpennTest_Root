var member = $('#connectedMember').text();
var author = $('#author').val();

console.log(member + author);

if (member != author) {
    $('#updatebtn').css('display', 'none');
    $('#btn-delete').css('display', 'none');
}