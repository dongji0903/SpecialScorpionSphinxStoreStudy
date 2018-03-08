$(function() {
	$('#dialog').dialog({
		autoOpen: false,
		resizable: false,
		buttons: [
			{
				text: "예",
				click: function() {
					dialYes();
				}
			},
			{
				text: "아니오",
				click: function() {
					dialNo();
				}
			}
		]
	});
	$('#button_open_dialog').click( function(){
		$('#dialog').dialog('open');
	});
});