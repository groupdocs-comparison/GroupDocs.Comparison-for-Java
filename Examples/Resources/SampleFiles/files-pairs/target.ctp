<!-- src/Template/Posts/view.ctp -->
<?php
$this->extend('/Common/view');

$this->assign('title', $post->title);

$this->start('frontbar');
?>
<li>
<?php
echo $this->Html->link('edit', [
    'action' => 'edit',
    $post->id
]);
?>
</li>
<?php $this->end(); ?>

<?= h($post->body) ?>